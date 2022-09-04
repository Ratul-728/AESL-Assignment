package Assignment.Assignment.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(path = "/api")
public class UserController {
    private final UserService userService;

    private final UserResponse userResponse = new UserResponse();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "create-user")
    public Object createUser(@RequestBody User user){
        Object obj = userService.createUser(user);

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