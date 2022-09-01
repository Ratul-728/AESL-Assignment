package Assignment.Assignment.User;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    //need to learn
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String dob;
    private String address;
    private String email;
    private String gender;

    enum gender{
        Male,
        Female,
        Other
    }

    public User() {

    }

    public User(String name, String dob, String address, String email, String gender) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public User(Long id, String name, String dob, String address, String email, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
