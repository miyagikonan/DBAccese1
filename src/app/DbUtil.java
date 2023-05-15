package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {


    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "testuser", "test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
