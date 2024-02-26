package org.example.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedicalVisit {

    private int id;
    private LocalDate date;
    private LocalTime time;
    private final Doctor doctor;
    private Patient patient;

    public MedicalVisit(LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    String medicalVisitStatus = patient == null ? "available" : "busy";

    @Override
    public String toString() {
        return "MedicalVisit: " + "\n" +
                "date: " + date + "\n" +
                "time: " + time + "\n" +
                "doctor: " + doctor + "\n" +
                "status: " +  medicalVisitStatus;
    }
}
