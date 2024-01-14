package by.yury.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_DEPOSIT")

public class  Deposit {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "deposit_uuid2")
    @GeneratedValue(generator = "deposit_uuid2")

    @Column(name = "DEPOSIT_ID")
    private String depositId;

    @Column(name = "SUM_DEPOSIT")
    private String sumDeposit;

    @Column(name = "PERSENT_DEPOSIT")
    private String persentDeposit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Client client;


    public Deposit(String depositId, String sumDeposit, String persentDeposit) {
        this.depositId = depositId;
        this.sumDeposit = sumDeposit;
        this.persentDeposit = persentDeposit;
    }

    public Deposit() {
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getSumDeposit() {
        return sumDeposit;
    }

    public void setSumDeposit(String sumDeposit) {
        this.sumDeposit = sumDeposit;
    }

    public String getPersentDeposit() {
        return persentDeposit;
    }

    public void setPersentDeposit(String persentDeposit) {
        this.persentDeposit = persentDeposit;
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
        Deposit deposit = (Deposit) object;
        return Objects.equals(depositId, deposit.depositId) && Objects.equals(sumDeposit, deposit.sumDeposit) && Objects.equals(persentDeposit, deposit.persentDeposit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositId, sumDeposit, persentDeposit);
    }
}