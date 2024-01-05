package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_SERVICE")

public class  Service {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "service_uuid2")
    @GeneratedValue(generator = "service_uuid2")

    @Column(name = "SERVICE_ID")
    private String serviceId;


    @Column(name = "CARD_TRANSFER_ID")
    private String cardTransferId;


    @Column(name = "PAYMENT_ID")
    private String paymentId;

    public Service(String serviceId, String cardTransferId, String paymentId) {
        this.serviceId = serviceId;
        this.cardTransferId = cardTransferId;
        this.paymentId = paymentId;
    }

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCardTransferId() {
        return cardTransferId;
    }

    public void setCardTransferId(String cardTransferId) {
        this.cardTransferId = cardTransferId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Service service = (Service) object;
        return Objects.equals(serviceId, service.serviceId) && Objects.equals(cardTransferId, service.cardTransferId) && Objects.equals(paymentId, service.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, cardTransferId, paymentId);
    }
}


