package by.yury.service.model;

public class CardFromWeb {

    private String id;

    private String cardName;

    private String cash;

    public CardFromWeb() {
    }

    public CardFromWeb(String id, String cardName, String cash) {
        this.id = id;
        this.cardName = cardName;
        this.cash = cash;
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

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

}
