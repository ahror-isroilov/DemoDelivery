package demo.delivery_project.common.constant;

import java.io.File;

public interface Constants {
    Integer TOKEN_LENGTH = 32;
    Integer FILE_NAME_LENGTH = 15;
    Long ACCESS_TOKEN_EXPIRATION_S = 86400L;
    Long REFRESH_TOKEN_EXPIRATION_S = 86400L * 30;
    String BCRYPT_PASSWORD_HASH = "bcrypt";
    String SCRYPT_PASSWORD_HASH = "scrypt";

    String UPLOAD_PATH = "var%sdemodelivery%simages".formatted(File.separator, File.separator);
    Integer MAX_FILE_SIZE = 10 * 1024 * 1024;
    String FILE_VIEW_URL = "http://localhost:8080/image/view/";
}
