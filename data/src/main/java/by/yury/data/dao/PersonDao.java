package by.yury.data.dao;

import by.yury.data.pojo.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    String saveNewPerson(Person person);

    public List<String> readPassport() throws SQLException, ClassNotFoundException;




}
