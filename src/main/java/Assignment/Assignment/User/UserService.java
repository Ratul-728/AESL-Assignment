package Assignment.Assignment.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
         Optional<User> existEmail = userRepository.findByEmail(user.getEmail());

         if(existEmail.isPresent()){
             throw new IllegalStateException("Email Exist");
         }

        userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        boolean existuser = userRepository.existsById(userId);
        if(!existuser){
            throw new IllegalStateException("User doesn't found");
        }

        userRepository.deleteById(userId);
    }

    public void updateUser(Long userId, String name, String email, String address) {
        userRepository.updateUser(userId, name, email, address);
    }

    public String show() {
        return "Done";
    }
}
