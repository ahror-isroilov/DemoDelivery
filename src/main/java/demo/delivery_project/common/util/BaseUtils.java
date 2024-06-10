package demo.delivery_project.common.util;

import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BaseUtils {
    @Autowired
    GetUserRoleOutPort getUserRoleOutPort;

    public static String generateUniqueString(Integer count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
