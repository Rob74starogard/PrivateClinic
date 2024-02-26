package org.example.service;

import org.example.domain.model.Doctor;
import org.example.domain.model.MedicalVisit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class MedicalVisitService {

    private List<MedicalVisit> medicalVisits;

    public MedicalVisitService() {
        this.medicalVisits = new LinkedList<>();
        Doctor doctor = new Doctor(
                "Maria",
                "Kowalska",
                "DoctorMK",
                "Dmk1!",
                "Internal Medicine");
        this.medicalVisits.add(new MedicalVisit(
                LocalDate.of(2024, 2, 23),
                LocalTime.of(8, 0),
                doctor,
                null));
        this.medicalVisits.add(new MedicalVisit(
                LocalDate.of(2024, 2, 23),
                LocalTime.of(8, 30),
                doctor,
                null));
        this.medicalVisits.add(new MedicalVisit(
                LocalDate.of(2024, 2, 23),
                LocalTime.of(9, 0),
                doctor,
                null));
    }

    public List<MedicalVisit> getMedicalVisits() {
        return medicalVisits;
    }

    public void addAMedicalVisit(MedicalVisit medicalVisit) {
        if (medicalVisit.getPatient() == null) {
            throw new RuntimeException("Sorry, it is not possible to add a medical visit, the " +
                    "entered data is incomplete!");
        }
        int index = medicalVisits.indexOf(getVisitByDateTimeDoctor(medicalVisit.getDate(),
                medicalVisit.getTime(), medicalVisit.getDoctor()));
        if (index == -1) {
            throw new RuntimeException("Sorry, it is not possible to add a medical visit, the " +
                    "entered data is incorrect!");
        }
        medicalVisits.get(index).setPatient(medicalVisit.getPatient());
    }

    public void deleteMedicalVisit(int id) {
        int index = medicalVisits.indexOf(getById(id));
        if (index == -1) {
            throw new RuntimeException("Sorry, it is not possible to delete a medical visit with " +
                    "the given id!");
        }
        MedicalVisit medicalVisit = medicalVisits.get(index);
        medicalVisits.remove(medicalVisit);
    }

    public void cancelMedicalVisit(int id) {
        int index = medicalVisits.indexOf(getById(id));
        if (index == -1) {
            throw new RuntimeException("Sorry, it is not possible to cancel a medical visit with " +
                    "the given id!");
        }
        MedicalVisit medicalVisit = medicalVisits.get(index);
        medicalVisits.get(medicalVisits.indexOf(getById(id))).setPatient(null);
    }

    public MedicalVisit viewMedicalVisits() {
        for (MedicalVisit medicalVisit : medicalVisits) {
            System.out.println(medicalVisit);
        }
        return null;
    }

    public MedicalVisit getById(int id) { //auxiliary method
        for (MedicalVisit medicalVisit : medicalVisits)
            if (medicalVisit.getId() == id) {
                return medicalVisit;
            }
        return null;
    }

    public MedicalVisit getVisitByDateTimeDoctor(LocalDate date, LocalTime time, Doctor doctor) { //auxiliary method
        for (MedicalVisit medicalVisit : medicalVisits)
            if (medicalVisit.getDate().equals(date) &&
                    medicalVisit.getTime().equals(time) &&
                    medicalVisit.getDoctor().equals(doctor)) {
                return medicalVisit;
            }
        return null;
    }
}
