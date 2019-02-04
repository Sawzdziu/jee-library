package library.model.dao;

import library.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Adam", "Kowalski", "Klient", "akowal", "test", "Wroclaw"));
        users.add(new User("Justyna", "Kawka", "Pracownik", "jkawka", "test", "Wroclaw"));
        users.add(new User("Piotr", "Nowak", "Klient", "pnowak", "test", "Opole"));
        users.add(new User("Marcin", "Adamkowski", "Pracownik", "madamkowski", "test", "Zgorzelec"));
        users.add(new User("Katarzyna", "Opel", "Klient", "kopel", "test", "Wroclaw"));
        users.add(new User("Eustachy", "Motyka", "Klient", "emotyka", "test", "Grajewo"));
    }

    public static void addUser(User user) {
        boolean exist = users.stream().noneMatch(u -> u.equals(user));
        if (exist) {
            users.add(user);
        }
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static void deleteUser(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public static void updateUser(Integer id, String name, String surname, String role, String login, String password, String city) {
        User update = new User(id, name, surname, role, login, password, city);
        users.stream().filter(user -> user.equals(update)).forEach(user -> {
            user.setName(update.getName());
            user.setSurname(update.getSurname());
            user.setRole(update.getRole());
            user.setCity(update.getCity());
            user.setLogin(update.getLogin());
            user.setPassword(update.getPassword());
        });
    }
}
