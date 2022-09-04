package Assignment.Assignment.User;

public class UserDto {
    String userName;
    String userDob;
    String userAddress;
    String userEmail;
    String userGender;

    public UserDto() {
    }

    public UserDto(String userName, String userDob, String userAddress, String userEmail, String userGender) {
        this.userName = userName;
        this.userDob = userDob;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userGender = userGender;
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
}
