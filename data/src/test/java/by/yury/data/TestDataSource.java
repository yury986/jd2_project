package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataSource extends DataSource {

    private static TestDataSource dataSource;

    protected TestDataSource() throws ClassNotFoundException {
        super();
    }

    @Override
    protected Connection getCloneConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Bank_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new TestDataSource();
        }
        return dataSource.getCloneConnection();
    }

}
