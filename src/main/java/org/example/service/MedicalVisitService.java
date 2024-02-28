package org.example.service;

import org.example.domain.model.Doctor;
import org.example.domain.model.MedicalVisit;
import org.example.domain.model.Patient;

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

    public void makeADoctorAppointment(int id, Patient patient) {
        int index = medicalVisits.indexOf(getById(id));
        if (index == -1) {
            throw new RuntimeException("Sorry, it is not possible to make an medical visit with " +
                    "the given id!");
        }
        if (medicalVisits.get(index).getPatient() != null) {
            throw new RuntimeException("Sorry, the selected date is not available!");
        }
        medicalVisits.get(index).setPatient(patient);
    }

    public void addAMedicalVisit(MedicalVisit medicalVisit) {
        if (medicalVisit.getDate() == null ||
                medicalVisit.getTime() == null ||
                medicalVisit.getDoctor() == null) {
            throw new RuntimeException("Sorry, it is not possible to add a medical visit, the " +
                    "entered data is incomplete!");
        }
        int index = medicalVisits.indexOf(getVisitByDateTimeDoctor(medicalVisit.getDate(),
                medicalVisit.getTime(), medicalVisit.getDoctor()));
        if (index != -1) {
            throw new RuntimeException("Sorry, it is not possible to add a medical visit, the " +
                    "given visit already exists!");
        }
        medicalVisits.add(medicalVisit);
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
        medicalVisits.get(medicalVisits.indexOf(getById(id))).setPatient(null);
    }

    public MedicalVisit viewMedicalVisits(boolean viewForTheDoctor) { // true for the doctor in UserInterface
        for (MedicalVisit medicalVisit : medicalVisits) {
            if (viewForTheDoctor || medicalVisit.getPatient() == null) {
                System.out.println(medicalVisit);
            }
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
