package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public Client(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

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
