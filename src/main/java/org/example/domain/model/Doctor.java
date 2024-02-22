package org.example.domain.model;

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
}
