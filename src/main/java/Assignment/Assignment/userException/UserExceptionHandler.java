package Assignment.Assignment.userException;

import Assignment.Assignment.User.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        UserResponse userResponse = new UserResponse();
        userResponse.setMsg("Validation Failed");
        List<String> errMsg = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < ex.getErrorCount(); i++) {
            errMsg.add(ex.getFieldErrors().get(i).getField()+": "+ex.getAllErrors().get(i).getDefaultMessage());
//            map.put(ex.getFieldErrors().get(i).getField()
//                    ,ex.getAllErrors().get(i).getDefaultMessage());
        }
        userResponse.setErrorData(errMsg);
        userResponse.setStatus("BAD_REQUEST");
        userResponse.setData(null);
        return ResponseEntity.badRequest().body(userResponse);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        UserResponse userResponse = new UserResponse();
        userResponse.setErrorData(ex.getMessage());
        userResponse.setMsg("Method Argument Type Mismatch Exception");
        userResponse.setStatus(ex.getLocalizedMessage());
        userResponse.setData(null);
        return ResponseEntity.badRequest().body(userResponse);
    }

//    @ExceptionHandler({SQL.class})
//    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setErrorData(ex.getMessage());
//        userResponse.setMsg("Method Argument Type Mismatch Exception");
//        userResponse.setStatus(ex.getLocalizedMessage());
//        userResponse.setData(null);
//        return ResponseEntity.badRequest().body(userResponse);
//    }


}
