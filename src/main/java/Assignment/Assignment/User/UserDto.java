package Assignment.Assignment.User;

import javax.swing.*;
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
    //@Pattern(message = "Password not valid", regexp = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))(?=(1)(?=.*\\d)|.*[^A-Za-z0-9])^.*$")
    //@Pattern(message = "Password must be 8 digits", regexp = "(?=^.{8,}$)")
    //@Pattern(message = "Password must have 1 Small letter", regexp = "[a-z]+")
//    @Pattern(message = "Password must have 1 Capital letter", regexp = "(?=.*[A-Z])")
//    @Pattern(message = "Password must have 1 Special letter", regexp = "(?=.*[\\*\\-_&%^$#@])")
//    @Pattern(message = "Password must have 1  Digit", regexp = "(?=.*[0-9])")
    @Pattern.List(value = {
            @Pattern(regexp = ".{8,}", message = "Password must have 8 digits."),
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain one digit."),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain one lowercase letter."),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one upper letter."),
            @Pattern(regexp = "(?=.*[!@#$%^&*+=?\\-_()/\"\\.,<>~`;:]).+", message = "Password must contain one special character."),
            @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
    })
    private String userPassword;

    public UserDto() {
    }

    public UserDto(String userName, String userDob, String userAddress, String userEmail, String userGender, String userContact, String userPassword) {
        this.userName = userName;
        this.userDob = userDob;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userContact = userContact;
        this.userPassword = userPassword;
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


    public String getUserPassword() {
        return userPassword;
    }
}
