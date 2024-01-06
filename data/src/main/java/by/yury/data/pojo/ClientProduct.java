package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_CLIENT_PRODUCT")
public class ClientProduct {
    @Id
    @GenericGenerator(strategy = "uuid", name = "clientproduct_uuid")
    @GeneratedValue(generator = "clientproduct_uuid")

    @Column(name= "CLIENT_PRODUCT_ID")
    private String ClientProductId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @OneToMany(mappedBy = "clientProduct")
    private List<Client> clients;

    @OneToMany(mappedBy = "clientProduct")
    private List<Product> products;

    public ClientProduct(String clientProductId, String userId, String productId) {
        ClientProductId = clientProductId;
        this.userId = userId;
        this.productId = productId;
    }

    public ClientProduct() {
    }

    public String getClientProductId() {
        return ClientProductId;
    }

    public void setClientProductId(String clientProductId) {
        ClientProductId = clientProductId;
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientProduct that = (ClientProduct) object;
        return Objects.equals(ClientProductId, that.ClientProductId) && Objects.equals(userId, that.userId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ClientProductId, userId, productId);
    }
}
