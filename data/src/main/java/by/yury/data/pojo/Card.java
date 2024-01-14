package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_CARD")

public class  Card {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "card_uuid2")
    @GeneratedValue(generator = "card_uuid2")

    @Column(name = "CARD_ID")
    private String id;

    @Column(name = "CARD_NAME")
    private String cardName;


    @Column(name = "CARD_NUMB")
    private String cardNumb;


    @Column(name = "CASH")
    private String cash;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;



    public Card(String id, String cardName, String cardNumb, String cash) {
        this.id = id;
        this.cardName = cardName;
        this.cardNumb = cardNumb;
        this.cash = cash;
    }

    public Card() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Card card = (Card) object;
        return Objects.equals(id, card.id) && Objects.equals(cardName, card.cardName) && Objects.equals(cardNumb, card.cardNumb) && Objects.equals(cash, card.cash) && Objects.equals(account, card.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardName, cardNumb, cash, account);
    }
}