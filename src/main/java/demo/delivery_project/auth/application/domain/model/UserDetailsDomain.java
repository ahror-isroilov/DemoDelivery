package demo.delivery_project.auth.application.domain.model;

import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Getter
public class UserDetailsDomain implements UserDetails, Authentication {
    @Getter
    private UUID id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private UserRole role;
    private UserStatus status;

    public UserDetailsDomain(UUID id, String username, String email, String firstname, String lastname, String password,
                             UserRole role, UserStatus status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions().stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return email;
    }

    @Override
    public boolean isAuthenticated() {
        return id != null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsDomain user = (UserDetailsDomain) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public String getName() {
        return firstname;
    }
}
