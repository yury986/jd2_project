package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_PRODUCT")

public class  Product {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "product_uuid2")
    @GeneratedValue(generator = "product_uuid2")

    @Column(name = "PRODUCT_ID")
    private String paymentId;


    @Column(name = "ACCOUNT_ID")
    private String accountId;


    @Column(name = "CARD_ID")
    private String cardId;


    @Column(name = "CREDIT_ID")
    private String creditId;


    @Column(name = "DEPOSIT_ID")
    private String depositId;

    public Product(String paymentId, String accountId, String cardId, String creditId, String depositId) {
        this.paymentId = paymentId;
        this.accountId = accountId;
        this.cardId = cardId;
        this.creditId = creditId;
        this.depositId = depositId;
    }

    public Product() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(paymentId, product.paymentId) && Objects.equals(accountId, product.accountId) && Objects.equals(cardId, product.cardId) && Objects.equals(creditId, product.creditId) && Objects.equals(depositId, product.depositId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, accountId, cardId, creditId, depositId);
    }
}
