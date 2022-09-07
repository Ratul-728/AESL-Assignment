package Assignment.Assignment.userException;

import Assignment.Assignment.User.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        UserResponse userResponse = new UserResponse();
        userResponse.setErrorData(ex.getName());
        userResponse.setMsg("Method Argument Type Mismatch Exception");
        userResponse.setStatus(ex.getErrorCode());
        userResponse.setData(null);
        return ResponseEntity.badRequest().body(userResponse);
    }
}
