package library.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {

    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/jee_library";
            String username = "root";
            String password = "root";
            Class.forName("org.postgresql.Driver").newInstance();
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
