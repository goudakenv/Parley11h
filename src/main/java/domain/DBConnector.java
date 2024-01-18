package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    public static Connection getConnections() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/parley_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Tokyo";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
