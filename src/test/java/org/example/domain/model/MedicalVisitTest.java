package org.example.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class MedicalVisitTest {

    @Test
    public void should_successfully_create_the_medical_visit() {
        //given
        LocalDate date = LocalDate.of(2024, 2, 22);
        LocalTime time = LocalTime.of(14, 0);
        Doctor doctor = new Doctor(
                "Maria",
                "Kowalska",
                "Internal Medicine",
                "DoctorMK",
                "Dmk1!");
        Patient patient = new Patient(
                "Zuzanna",
                "Nowak",
                "777555333",
                "PatientZN",
                "Pzn2!");

        //when
        MedicalVisit medicalVisit = new MedicalVisit(date, time, doctor, patient);
        
        //then
        assertThat(medicalVisit.getDate()).isNotNull();
        assertThat(medicalVisit.getDate()).isEqualTo(date);
        assertThat(medicalVisit.getTime()).isNotNull();
        assertThat(medicalVisit.getTime()).isEqualTo(time);
        assertThat(medicalVisit.getDoctor()).isNotNull();
        assertThat(medicalVisit.getDoctor().toString()).isEqualTo(doctor.toString());
        assertThat(medicalVisit.getPatient()).isNotNull();
        assertThat(medicalVisit.getPatient().toString()).isEqualTo(patient.toString());
    }
}