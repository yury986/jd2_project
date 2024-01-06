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
    private String serviceId;

    @OneToMany(mappedBy = "clientService")
    private List<Client> clients;


    @OneToMany(mappedBy = "clientService")
    private List<Service> services;

    public ClientService(String userId, String serviceId, List<Client> clients, List<Service> services) {
        this.userId = userId;
        this.serviceId = serviceId;
        this.clients = clients;
        this.services = services;
    }

    public ClientService() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientService that = (ClientService) object;
        return Objects.equals(userId, that.userId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(clients, that.clients) && Objects.equals(services, that.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, serviceId, clients, services);
    }
}
