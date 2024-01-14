package by.yury.data.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_CARD_TRANSFER")

public class  CardTransfer {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "card_uuid2")
    @GeneratedValue(generator = "card_uuid2")

    @Column(name = "CARD_TRANSFER_ID")
    private String id;


    @Column(name = "TRANSFER_AMOUNT")
    private String transferAmount;


    @Column(name = "CARD_NUMB_SENDER")
    private String cardNumbSender;


    @Column(name = "CARD_NUMB_RECIPIENT")
    private String cardNumbRecipient;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Client client;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SERVICE_ID")
//    private Service  service;

    public CardTransfer(String id, String transferAmount, String cardNumbSender, String cardNumbRecipient) {
        this.id = id;
        this.transferAmount = transferAmount;
        this.cardNumbSender = cardNumbSender;
        this.cardNumbRecipient = cardNumbRecipient;
    }

    public CardTransfer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getCardNumbSender() {
        return cardNumbSender;
    }

    public void setCardNumbSender(String cardNumbSender) {
        this.cardNumbSender = cardNumbSender;
    }

    public String getCardNumbRecipient() {
        return cardNumbRecipient;
    }

    public void setCardNumbRecipient(String cardNumbRecipient) {
        this.cardNumbRecipient = cardNumbRecipient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CardTransfer that = (CardTransfer) object;
        return Objects.equals(id, that.id) && Objects.equals(transferAmount, that.transferAmount) && Objects.equals(cardNumbSender, that.cardNumbSender) && Objects.equals(cardNumbRecipient, that.cardNumbRecipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transferAmount, cardNumbSender, cardNumbRecipient);
    }
}
