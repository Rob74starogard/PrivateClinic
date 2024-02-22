package org.example.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class MedicalVisit {

    private UUID id;
    private LocalDate date;
    private LocalTime time;
    private final Doctor doctor;
    private final Patient patient;

    public MedicalVisit(LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
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
}
