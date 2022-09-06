package Assignment.Assignment.User;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {
    @NotNull(message = "Name can not be null")
    private String userName;
    private String userDob;
    private String userAddress;
    @Pattern(message = "Email not valid", regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String userEmail;
    private String userGender;

    private String userContact;

    public UserDto() {
    }

    public UserDto(String userName, String userDob, String userAddress, String userEmail, String userGender, String userContact) {
        this.userName = userName;
        this.userDob = userDob;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userContact = userContact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }
}
