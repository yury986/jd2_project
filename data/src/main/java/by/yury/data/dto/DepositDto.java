package by.yury.data.dto;

public class DepositDto {

    private String depositId;

    private String depositSum;

    private String depositPercent;

    public DepositDto(String depositId, String depositSum, String depositPercent) {
        this.depositId = depositId;
        this.depositSum = depositSum;
        this.depositPercent = depositPercent;
    }

    public DepositDto() {
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(String depositSum) {
        this.depositSum = depositSum;
    }

    public String getDepositPercent() {
        return depositPercent;
    }

    public void setDepositPercent(String depositPercent) {
        this.depositPercent = depositPercent;
    }

}
