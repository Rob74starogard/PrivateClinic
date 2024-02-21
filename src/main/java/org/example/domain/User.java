package org.example.domain;

import java.util.UUID;

public abstract class User {

    UUID id;
    String name;
    String surname;

    public User(String name, String surname) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
