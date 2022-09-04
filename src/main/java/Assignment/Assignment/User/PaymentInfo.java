package Assignment.Assignment.User;

import javax.persistence.*;

@Entity
@Table
public class PaymentInfo {
    @Id
    //need to learn
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long id;
    String accountNumber;
    Double amount;

    public PaymentInfo(String accountNumber, Double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public PaymentInfo(Long id, String accountNumber, Double amount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public PaymentInfo() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
