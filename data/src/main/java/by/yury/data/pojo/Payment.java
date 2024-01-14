package by.yury.data.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_PAYMENT")

public class  Payment {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "payment_uuid2")
    @GeneratedValue(generator = "payment_uuid2")

    @Column(name = "PAYMENT_ID")
    private String paymentId;

    @Column(name = "PAYMENT_SUM")
    private String paymentSum;


    @Column(name = "RECIPIENT")
    private String recipient;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Client client;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SERVICE_ID")
//    private Service  service;

    public Payment(String paymentId, String paymentSum, String recipient) {
        this.paymentId = paymentId;
        this.paymentSum = paymentSum;
        this.recipient = recipient;
    }

    public Payment() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(String paymentSum) {
        this.paymentSum = paymentSum;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }


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
        Payment payment = (Payment) object;
        return Objects.equals(paymentId, payment.paymentId) && Objects.equals(paymentSum, payment.paymentSum) && Objects.equals(recipient, payment.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, paymentSum, recipient);
    }
}
