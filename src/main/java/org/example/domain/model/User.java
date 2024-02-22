package org.example.domain.model;

import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;

public abstract class User {

    private UUID id;
    private String name;
    private String surname;
    private String nickName;
    private String password;

    public User(String name, String surname, String nickName, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.password = DigestUtils.md5Hex(password).toUpperCase();
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
                "nickName: " + nickName + "\n" +
                "password: " + password;
    }
}
