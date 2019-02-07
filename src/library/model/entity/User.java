package library.model.entity;

import java.util.Objects;

public class User {

    private static Integer actualID = 0;
    private Integer id;
    private String name;
    private String surname;
    private String role;
    private String login;
    private String password;
    private String city;

    public User() {
        this.id = -1;
        this.name = "Test";
        this.surname = "Test";
        this.role = "Role";
        this.login = "Login";
        this.password = "Password";
        this.city = "City";
    }

    public User(String name, String surname, String role, String login, String city) {
        this(actualID++, name, surname, role, login, "", city);
    }


    public User(String name, String surname, String role, String login, String password, String city) {
        this(actualID++, name, surname, role, login, password, city);
    }

    public User(Integer id, String name, String surname, String role, String login, String password, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.login = login;
        this.password = password;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(role, user.role) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, role, login, password, city);
    }
}
