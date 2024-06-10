package demo.delivery_project.common.exception;

public class UserDisabledException extends RuntimeException {
    public UserDisabledException() {
        super(ErrorMessages.USER_DISABLED);
    }
}
