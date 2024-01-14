package by.yury.data.dto;

import by.yury.data.pojo.Account;
import org.springframework.stereotype.Component;

@Component
public class CardDto {

    private  String id;

    private String cardName;

    private String cardNumb;

    private String cash;

    private AccountDto accountDto;

    public CardDto(String id, String cardName, String cardNumb, String cash) {
        this.id = id;
        this.cardName = cardName;
        this.cardNumb = cardNumb;
        this.cash = cash;
    }

    public CardDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
