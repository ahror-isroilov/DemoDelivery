package demo.delivery_project.common.password_encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomPasswordEncoderImpl implements CustomPasswordEncoder {
    private final Map<String, PasswordEncoder> encoders;
    private String algorithm;

    public CustomPasswordEncoderImpl() {
        encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder(1024, 8, 1, 32, 16));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        PasswordEncoder encoder = encoders.get(algorithm);
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        PasswordEncoder encoder = encoders.get(algorithm);
        return encoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public String encodeWith(String rawPassword, String algorithm) {
        this.algorithm = algorithm;
        return encode(rawPassword);
    }

    @Override
    public boolean matchesWith(CharSequence rawPassword, String encodedPassword, String algorithm) {
        this.algorithm = algorithm;
        return matches(rawPassword, encodedPassword);
    }
}
