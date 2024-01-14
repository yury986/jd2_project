package by.yury.data.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
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

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Client client;

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountCurrency, account.accountCurrency) && Objects.equals(cards, account.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, accountCurrency, cards);
    }
}