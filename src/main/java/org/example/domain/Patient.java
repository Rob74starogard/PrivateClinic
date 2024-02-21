package org.example.domain;

public class Patient extends User {

    String phoneNumber;

    public Patient(String phoneNumber, String name, String surname) {
        super(name, surname);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
