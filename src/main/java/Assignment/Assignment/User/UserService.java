package Assignment.Assignment.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    private final UserResponse userResponse = new UserResponse();

    public UserService(UserRepository userRepository, PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }

    public UserResponse createUser(UserDto userDto) {
         User user = new User();

         user.setName(userDto.getUserName());
         user.setEmail(userDto.getUserEmail());
         user.setDob(userDto.getUserDob());
         user.setAddress(userDto.getUserAddress());
         user.setGender(userDto.getUserGender());
         user.setContact(userDto.getUserContact());
         user.setPassword(userDto.getUserPassword());


//         Optional<User> existEmail = userRepository.findByEmail(user.getEmail());
//
//         if(existEmail.isPresent()){
//             throw new IllegalStateException("Email Exist");
//         }
        try{
            userRepository.save(user);
        }
        catch(Exception e){
            e.printStackTrace();
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg(e.getMessage());
            userResponse.setData(null);
            return userResponse;
        }

        userResponse.setMsg("Successfully a user created");
        userResponse.setStatus("Success!");
        userResponse.setData(userDto);
        userResponse.setErrorData(null);

         return userResponse;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> deleteUser(Long userId) {
        boolean existuser = userRepository.existsById(userId);
        if(!existuser){
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg("User not found");
            userResponse.setErrorData("UserID not found");
            userResponse.setData(null);
            return ResponseEntity.badRequest().body(userResponse);
        }
        userResponse.setStatus("GOOD_REQUEST");
        userResponse.setMsg("User deleted Successfully");
        userResponse.setErrorData(null);
        userResponse.setData(null);

        try{
            userRepository.deleteById(userId);
        }catch (Exception e){
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg(e.getMessage());
            userResponse.setErrorData(e.getCause());
            userResponse.setData(null);

            return ResponseEntity.badRequest().body(userResponse);
        }

        return ResponseEntity.accepted().body(userResponse);
    }

    public UserResponse updateUser(Long userId, String name, String email, String address) {

        int check =  userRepository.updateUser(userId, name, email, address);
        if(check == 0){
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg("User Updated Not Successfully!");
            userResponse.setData(null);
            userResponse.setErrorData("User not found");
        }else{
            userResponse.setStatus("GOOD_REQUEST");
            userResponse.setMsg("User Updated Successfully!");
            userResponse.setData(null);
            userResponse.setErrorData(null);
        }
        return userResponse;
    }

    public ResponseEntity payment(PaymentInfo paymentInfo) {
        try{
            paymentRepository.save(paymentInfo);

        }catch (Exception e){
            userResponse.setErrorData(e.getMessage());
            userResponse.setMsg("Payment Decline");
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setData(null);

            return ResponseEntity.badRequest().body(userResponse);
        }

        userResponse.setMsg("Payment Successfully");
        userResponse.setStatus("GOOD_REQUEST");
        userResponse.setData(paymentInfo);
        userResponse.setErrorData(null);

        return ResponseEntity.accepted().body(userResponse);
    }

    public ResponseEntity getUserById(Long userId) {
        boolean existuser = userRepository.existsById(userId);
        if(!existuser){
            userResponse.setStatus("BAD_REQUEST");
            userResponse.setMsg("User not found");
            userResponse.setErrorData("UserID not found");
            userResponse.setData(null);
            return ResponseEntity.badRequest().body(userResponse);
        }else{
            try{
                Optional<User> userById = userRepository.findById(userId);
                userResponse.setStatus("GOOD_REQUEST");
                userResponse.setMsg("User found");
                userResponse.setErrorData(null);
                userResponse.setData(userById);
                return ResponseEntity.accepted().body(userResponse);

            }catch (Exception e){
                throw new IllegalStateException("Something went wrong!");

            }
        }

    }
}
