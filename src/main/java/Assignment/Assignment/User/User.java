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
    //@NotNull(message = "Name should not be null")
    //@Size(min = 1, max = 45)
    private String name;
    private String dob;
    private String address;

    private String password;

    //@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(unique = true)
    private String email;
    private String gender;
    //@Pattern(regexp = "^\\+8801\\d{9}")
    private String contact;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    enum gender{
        Male,
        Female,
        Other
    }

    public User() {

    }

    public User(String name, String dob, String address, String password, String email, String gender, String contact) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.contact = contact;
    }

    public User(Long id, String name, String dob, String address, String password, String email, String gender, String contact) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", contact=" + contact +
                ", contact=" + password +
                '}';
    }
}
