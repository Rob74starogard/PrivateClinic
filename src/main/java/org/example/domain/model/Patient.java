package org.example.domain.model;

public class Patient extends User {

    private String phoneNumber;

    public Patient(String name, String surname, String nickName,
                   String password, String phoneNumber) {
        super(name, surname, nickName, password);
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nphone number: " + phoneNumber + "\n";
    }
}
