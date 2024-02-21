package org.example.domain;

public class Doctor extends User {

    String specialization;

    public Doctor(String specialization, String name, String surname) {
        super(name, surname);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
