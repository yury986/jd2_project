package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "T_CLIENT_SERVICE")
public class ClientService {
    @Id
    @GenericGenerator(strategy = "uuid", name = "clientservice_uuid")
    @GeneratedValue(generator = "clientservice_uuid")

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "SERVICE_ID")
    private String productId;


    @OneToMany(mappedBy = "clientService")
    private List<Client> clients;


    @OneToMany(mappedBy = "clientService")
    private List<Service> services;


    public ClientService(String userId, String productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public ClientService() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientService that = (ClientService) object;
        return Objects.equals(userId, that.userId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }
}

