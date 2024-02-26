package org.example.domain.model;

import java.util.Objects;

public abstract class User {

    private int id;
    private String name;
    private String surname;
    private String nickName;
    private String password;
    public static int counter = 0;

    public User(String name, String surname, String nickName, String password) {
        this.id = counter;
        User.counter++;
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + "\n" +
                "name: " + name + "\n" +
                "surname: " + surname + "\n" +
                "nickName: " + nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nickName, password);
    }
}
