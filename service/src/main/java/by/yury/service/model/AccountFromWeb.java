package by.yury.service.model;

public class AccountFromWeb {

    private String id;


    private String accountCurrency;

    public AccountFromWeb(String id, String accountCurrency) {
        this.id = id;
        this.accountCurrency = accountCurrency;
    }

    public AccountFromWeb() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

}
