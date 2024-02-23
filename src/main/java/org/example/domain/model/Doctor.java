package org.example.domain.model;

import java.util.Objects;

public class Doctor extends User {

    private String specialization;

    public Doctor(String name, String surname, String nickName,
                  String password, String specialization) {
        super(name, surname, nickName, password);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "\nspecialization: " + specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(specialization, doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialization);
    }
}
