package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_CREDIT")

public class  Credit {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "credit_uuid2")
    @GeneratedValue(generator = "credit_uuid2")

    @Column(name = "CREDIT_ID")
    private String creditId;

    @Column(name = "SUM_CREDIT")
    private String sumCredit;


    @Column(name = "PERSENT_CREDIT")
    private String persentCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Client client;



    public Credit(String creditId, String sumCredit, String persentCredit) {
        this.creditId = creditId;
        this.sumCredit = sumCredit;
        this.persentCredit = persentCredit;
    }

    public Credit() {
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(String sumCredit) {
        this.sumCredit = sumCredit;
    }

    public String getPersentCredit() {
        return persentCredit;
    }

    public void setPersentCredit(String persentCredit) {
        this.persentCredit = persentCredit;
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
        Credit credit = (Credit) object;
        return Objects.equals(creditId, credit.creditId) && Objects.equals(sumCredit, credit.sumCredit) && Objects.equals(persentCredit, credit.persentCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, sumCredit, persentCredit);
    }
}
