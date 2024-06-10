package demo.delivery_project.common.auditing;

import demo.delivery_project.auth.application.domain.model.UserDetailsDomain;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class AuditorAwareImpl implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UUID id = extractPrincipal(securityContext.getAuthentication()).orElse(null);
        return Optional.ofNullable(id);
    }

    private static Optional<UUID> extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return Optional.empty();
        } else if (authentication.getPrincipal() instanceof UserDetailsDomain springSecurityUser) {
            return Optional.ofNullable(springSecurityUser.getId());
        }
        return Optional.empty();
    }
}
