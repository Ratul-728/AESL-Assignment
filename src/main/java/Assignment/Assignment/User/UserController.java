package Assignment.Assignment.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Object createUser(@RequestBody @Valid UserDto userDto, BindingResult result/*, Model model*/)throws Exception{

        //System.out.println("Result -> "+objectMapper.writeValueAsString(result));
        if(result.hasErrors()){
            return result;
        }
        Object obj = userService.createUser(userDto);

        return obj;
    }

    @GetMapping(path = "get-user")
    public List<User> getUser(){
        return userService.getUser();
    }

    @DeleteMapping(path = "delete-user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "update-user/{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String address){
        userService.updateUser(userId, name, email, address);
    }
    @PostMapping(path = "payment")
    public Object paymnet(@RequestBody PaymentInfo paymentInfo){
        Object paymentObj = userService.payment(paymentInfo);

        return paymentObj;
    }



}
