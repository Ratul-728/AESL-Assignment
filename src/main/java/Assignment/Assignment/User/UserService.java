package Assignment.Assignment.User;

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

    public Object createUser(UserDto userDto) {
         User user = new User();

         user.setName(userDto.getUserName());
         user.setEmail(userDto.getUserEmail());
         user.setDob(userDto.getUserDob());
         user.setAddress(userDto.getUserAddress());
         user.setGender(userDto.getUserGender());

         Optional<User> existEmail = userRepository.findByEmail(user.getEmail());

         if(existEmail.isPresent()){
             throw new IllegalStateException("Email Exist");
         }

        userRepository.save(user);

        userResponse.setMsg("Successfully a user created");
        userResponse.setStatus("200");
        /*String str = "Name: "+user.getName()+"Email: " +user.getEmail()+
                " Address: " +user.getAddress()+
                " Gender: " +user.getGender()+
                " Dob: "+user.getDob();*/
        userResponse.setData(userDto);

         return userResponse;
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

    public Object payment(PaymentInfo paymentInfo) {
        paymentRepository.save(paymentInfo);

        userResponse.setMsg("Payment Successfull");
        userResponse.setStatus("200");
        userResponse.setData(paymentInfo);

        return userResponse;
    }
}
