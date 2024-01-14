package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_CLIENT")
public class Client {
    @Id
    @GenericGenerator(strategy = "uuid", name = "user_uuid")
    @GeneratedValue(generator = "user_uuid")

    @Column(name = "USER_ID")
    private String id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;



    @Column(name = "USER_ROLE")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;


    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @OneToMany(mappedBy = "client")
    private List<Credit> credits;

    @OneToMany(mappedBy = "client")
    private List<Deposit> deposits;

    @OneToMany(mappedBy = "client")
    private List<CardTransfer> cardTransfers;

    @OneToMany(mappedBy = "client")
    private List<Payment> payments ;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CLIENT_PRODUCT_ID")
//    private ClientProduct  clientProduct;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CLIENT_SERVICE_ID")
//    private ClientService  clientService;


    public Client(String id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<CardTransfer> getCardTransfers() {
        return cardTransfers;
    }

    public void setCardTransfers(List<CardTransfer> cardTransfers) {
        this.cardTransfers = cardTransfers;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    //    public ClientProduct getClientProduct() {
//        return clientProduct;
//    }
//
//    public void setClientProduct(ClientProduct clientProduct) {
//        this.clientProduct = clientProduct;
//    }
//
//    public ClientService getClientService() {
//        return clientService;
//    }
//
//    public void setClientService(ClientService clientService) {
//        this.clientService = clientService;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Client client = (Client) object;
        return Objects.equals(id, client.id) && Objects.equals(userName, client.userName) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password);
    }
}
