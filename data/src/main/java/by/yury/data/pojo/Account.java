package by.yury.data.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_ACCOUNT")
public class Account {
    @Id
    @GenericGenerator(strategy = "uuid", name = "account_uuid")
    @GeneratedValue(generator = "account_uuid")

    @Column(name = "ACCOUNT_ID")
    private String id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_CURRENCY")
    private String accountCurrency;

    public Account(String id, String accountNumber, String accountCurrency) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountCurrency = accountCurrency;
    }

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}