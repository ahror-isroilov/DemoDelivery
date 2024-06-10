package demo.delivery_project.auth.application.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.delivery_project.auth.application.domain.model.UserDetailsDomain;
import demo.delivery_project.common.configuration.SecurityConfig;
import demo.delivery_project.common.exception.ProblemDetail;
import demo.delivery_project.token.application.domain.model.AccessToken;
import demo.delivery_project.token.application.usecase.out.GetAccessTokenOutPort;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private GetAccessTokenOutPort getAccessTokenOutPort;
    @Autowired
    private GetUserOutPort getUserOutPort;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            sendError(response);
            return;
        }

        token = token.substring("Bearer ".length());
        Optional<AccessToken> accessTokenOptional = getAccessTokenOutPort.getOptional(token);
        if (accessTokenOptional.isEmpty()) {
            sendError(response);
            return;
        }

        AccessToken accessToken = accessTokenOptional.get();
        User user = getUserOutPort.get(accessToken.getUserId());
        UserDetailsDomain userDetailsDomain = userDetailsService.createSpringSecurityUser(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetailsDomain,
                userDetailsDomain.getPassword(),
                userDetailsDomain.getAuthorities()
        );
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return SecurityConfig.UNSECURED_ENDPOINTS.entrySet().stream()
                .anyMatch(entry -> new AntPathRequestMatcher(entry.getKey()).matches(request)
                        && entry.getValue().name().equals(request.getMethod()));
    }

    private void sendError(HttpServletResponse httpServletResponse) throws IOException {
        ProblemDetail problemDetail = ProblemDetail.builder().status(HttpStatus.UNAUTHORIZED.value())
                .type("UnauthorizedException")
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.getWriter().print(objectMapper.writeValueAsString(problemDetail));
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
