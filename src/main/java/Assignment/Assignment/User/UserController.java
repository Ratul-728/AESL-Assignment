package Assignment.Assignment.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    private final UserService userService;

    private final UserResponse userResponse = new UserResponse();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "create-user")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto userDto, BindingResult result/*, Model model*/){

        //System.out.println("Result -> "+objectMapper.writeValueAsString(result));
        if(result.hasErrors()){
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg("Validation Failed");
            List<String> errMsg = new ArrayList<>();
            Map<String, String> map = new HashMap<>();

            for (int i = 0; i < result.getAllErrors().size(); i++) {
                //errMsg.add(result.getAllErrors().get(i).getDefaultMessage());
                map.put(result.getFieldErrors().get(i).getField()
                        ,result.getAllErrors().get(i).getDefaultMessage());
            }
            userResponse.setErrorData(map);
            userResponse.setData(null);
            return ResponseEntity.badRequest()
                    .body(userResponse);
            //return userResponse;
        }
        UserResponse response = userService.createUser(userDto);
        return ResponseEntity.accepted()
                .body(response);
        //return obj;
    }

    @GetMapping(path = "get-user")
    public ResponseEntity<List<User>> getUser(){
        //return userService.getUser();
        return ResponseEntity.accepted()
                .body(userService.getUser());
    }

    @DeleteMapping(path = "delete-user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        return userService.deleteUser(userId);
    }

    @PutMapping(path = "update-user/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String address){
        Object obj = userService.updateUser(userId, name, email, address);
        return ResponseEntity.accepted().body(obj);
    }
    @PostMapping(path = "payment")
    public ResponseEntity<?> paymnet(@RequestBody PaymentInfo paymentInfo){
        ResponseEntity paymentObj = userService.payment(paymentInfo);

        return paymentObj;
    }
    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam int yearOfBirth){
        if(yearOfBirth > 2022){
            return ResponseEntity.badRequest().header("Bad-Request-Header", "Bad").body("You don't have time machine fool");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Foo");
        //return new ResponseEntity<>("Your Age is: "+(2022-yearOfBirth), headers,HttpStatus.ACCEPTED);
        return ResponseEntity.ok().body("Yor age is: "+(2022-yearOfBirth));
    }

}
