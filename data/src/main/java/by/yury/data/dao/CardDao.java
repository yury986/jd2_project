package by.yury.data.dao;


import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Card;

public interface CardDao {

    String saveNewCard(Card card);

    String createCardwithAccount(Card card);

    public Card readCardById(String id);

}
