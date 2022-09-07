package Assignment.Assignment.userException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.ResourceBundle;
//
////@ControllerAdvice
//public class ApiExceptionHandler {
//    @ExceptionHandler(value = {ApiRequestException.class})
//    public ResponseEntity<?> handleApiRequestException(ApiRequestException e){
//        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//        ApiException apiException = new ApiException(e.getMessage(),
//                e,
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("z"))
//        );
//
//        return ResponseEntity.badRequest().body(apiException);
//    }
//}
