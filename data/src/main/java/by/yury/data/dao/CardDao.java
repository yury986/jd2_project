package by.yury.data.dao;


import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Card;

public interface CardDao {

    String saveNewCard(Card card);

    void createCard(CardDto cardDto, AccountDto accountDto);

}
