package by.yury.data.dto;

public class CreditDto {

    private String creditId;

    private String creditSum;

    private String creditPercent;

    public CreditDto(String creditId, String creditSum, String creditPercent) {
        this.creditId = creditId;
        this.creditSum = creditSum;
        this.creditPercent = creditPercent;
    }

    public CreditDto() {
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(String creditSum) {
        this.creditSum = creditSum;
    }

    public String getCreditPercent() {
        return creditPercent;
    }

    public void setCreditPercent(String creditPercent) {
        this.creditPercent = creditPercent;
    }

}
