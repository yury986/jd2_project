package by.yury.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static DataSource dataSource;
    protected DataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getCloneConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Bank",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource.getCloneConnection();
    }

}
