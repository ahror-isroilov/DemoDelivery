package demo.delivery_project.common.util;

import demo.delivery_project.auth.application.domain.model.UserDetailsDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecurityUtils {
    public static UUID getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return extractPrincipal(securityContext.getAuthentication()).orElse(null);
    }

    private static Optional<UUID> extractPrincipal(Authentication authentication) {
        if (authentication == null) return Optional.empty();
        else if (authentication.getPrincipal() instanceof UserDetailsDomain springSecurityUser)
            return Optional.ofNullable(springSecurityUser.getId());
        return Optional.empty();
    }

}
