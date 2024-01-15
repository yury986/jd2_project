package by.yury.data.dao;


import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Card;

import java.sql.SQLException;

public interface CardDao {

    void UpdateCash(String id, String cash)  throws SQLException, ClassNotFoundException;

    String saveNewCard(Card card);

    public Card readCardById(String id);

    public Card readCardByNumber(String number);

}
