package library.model.dao;

import library.model.DataBaseConnector;
import library.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsersDAO {

    private static List<User> users = new ArrayList<>();

    static {
        try {
            addUser(new User("Adam", "Kowalski", "Klient", "akowal", "test", "Wroclaw"));
            addUser(new User("Justyna", "Kawka", "Pracownik", "jkawka", "test", "Wroclaw"));
            addUser(new User("Piotr", "Nowak", "Klient", "pnowak", "test", "Opole"));
            addUser(new User("Marcin", "Adamkowski", "Pracownik", "madamkowski", "test", "Zgorzelec"));
            addUser(new User("Katarzyna", "Opel", "Klient", "kopel", "test", "Wroclaw"));
            addUser(new User("Eustachy", "Motyka", "Klient", "emotyka", "test", "Grajewo"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean userExist(User user) throws SQLException {
        String userExist = "SELECT 1 FROM \"user\" WHERE username = ? limit 1;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(userExist);
        statement.setString(1, user.getLogin());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public static void addUser(User user) throws SQLException {
        if (!userExist(user)) {
            String addUser = "INSERT INTO \"user\" (name, surname, city, username, password, role) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(addUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getCity());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getRole());
            statement.executeUpdate();
            statement.close();
        }
    }

    public static List<User> getAllUsers() throws SQLException {
        ResultSet resultSet;
        Statement statement = DataBaseConnector.getConnection().createStatement();
        resultSet = statement.executeQuery("SELECT * FROM \"user\"");
        List<User> users = new LinkedList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String city = resultSet.getString("city");
            String role = resultSet.getString("role");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            users.add(new User(id, name, surname, role, username, password, city));
        }
        statement.close();
        return users;
    }

    public static void deleteUser(Integer id) throws SQLException {
        String deleteUser = "DELETE FROM \"user\" WHERE id = ?;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(deleteUser);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public static void updateUser(Integer id, String name, String surname, String role, String login, String password, String city) throws SQLException {
        String updateUser = "UPDATE \"user\" SET name = ?, surname = ?, role = ?, city = ?, username = ?, password = ? WHERE id = ?;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(updateUser);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, role);
        statement.setString(4, city);
        statement.setString(5, login);
        statement.setString(6, password);
        statement.setInt(7, id);
        statement.executeUpdate();
    }
}
