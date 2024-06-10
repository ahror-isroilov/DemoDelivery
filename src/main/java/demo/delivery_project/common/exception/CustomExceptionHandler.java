package demo.delivery_project.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ProblemDetail> handleRuntimeExceptions(Exception ex) {
        StackTraceElement[] stackTraces = ex.getStackTrace();
        StackTraceElement rootTrace = stackTraces[0];
        log.error(""" 
                \s
                error: {} \s
                type: {} \s
                class: {} \s
                method: {} \s
                line: {} \s
                """, ex.getMessage(), ex.getClass(), rootTrace.getClassName(), rootTrace.getMethodName(), rootTrace.getLineNumber());

        ProblemDetail problem = createProblem(ex);
        return new ResponseEntity<>(
                problem, HttpStatus.valueOf(problem.getStatus()));
    }

    private ProblemDetail createProblem(Exception ex) {
        ProblemDetail.ProblemDetailBuilder problemBuilder = ProblemDetail.builder();
        String message = ex.getMessage();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof DataNotFoundException) status = HttpStatus.NOT_FOUND;
        if (ex instanceof NotAcceptableException) status = HttpStatus.NOT_ACCEPTABLE;
        if (ex instanceof BadCredentialsException) status = HttpStatus.BAD_REQUEST;
        if (ex instanceof UserDisabledException) status = HttpStatus.NOT_ACCEPTABLE;
        if (ex instanceof MethodArgumentNotValidException) {
            status = HttpStatus.BAD_REQUEST;
            message = ((MethodArgumentNotValidException) ex).getFieldError().getDefaultMessage();
        }
        return problemBuilder
                .message(message)
                .status(status.value())
                .build();
    }
}
