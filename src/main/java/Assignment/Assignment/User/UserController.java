package Assignment.Assignment.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "create-user")
    public void createUder(@RequestBody User user){
        userService.createUser(user);
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

    @PostMapping(path="show")
    public String show(){
        userService.show();
        return userService.show();
    }


}
