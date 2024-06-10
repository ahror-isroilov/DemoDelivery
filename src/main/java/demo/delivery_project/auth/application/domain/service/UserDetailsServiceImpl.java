package demo.delivery_project.auth.application.domain.service;

import demo.delivery_project.auth.application.domain.model.UserDetailsDomain;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final GetUserOutPort getUserOutPort;
    private final GetUserRoleOutPort getUserRoleOutPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserOutPort.getByUsernameOrEmail(username);
        return createSpringSecurityUser(user);
    }

    public UserDetailsDomain createSpringSecurityUser(User user) {
        return new UserDetailsDomain(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword(),
                getUserRoleOutPort.get(user.getRoleId()),
                user.getStatus());
    }
}
