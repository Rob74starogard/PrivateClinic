package org.example.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Visit {

    UUID id;
    LocalDate date;
    LocalTime time;
    private Doctor doctor;
    private Patient patient;

    public Visit(LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }
}
