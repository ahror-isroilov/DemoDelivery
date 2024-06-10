package demo.delivery_project.common.password_encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface CustomPasswordEncoder extends PasswordEncoder {
    String encodeWith(String rawPassword, String algorithm);

    boolean matchesWith(CharSequence rawPassword, String encodedPassword, String algorithm);
}
