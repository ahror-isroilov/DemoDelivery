package demo.delivery_project.common.exception;

public class BadCredentialsException extends RuntimeException {
    public BadCredentialsException() {
        super(ErrorMessages.BAD_CREDENTIALS);
    }
}
