package org.example.service;

import org.example.domain.model.Doctor;
import org.example.domain.model.MedicalVisit;
import org.example.domain.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class MedicalVisitServiceTest {

    private MedicalVisitService medicalVisitServiceSuT;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;

    @BeforeEach
    void setUp() {
        medicalVisitServiceSuT = new MedicalVisitService();
        date = LocalDate.of(2024, 2, 23);
        time = LocalTime.of(8, 0);
        doctor = new Doctor(
                "Maria",
                "Kowalska",
                "DoctorMK",
                "Dmk1!",
                "Internal Medicine");
        patient = new Patient(
                "Zuzanna",
                "Nowak",
                "PatientZN",
                "Pzn2!",
                "777555333");
    }

    @Test
    public void should_add_a_medical_visit_successfully() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, time, doctor, patient);

        //when
        medicalVisitServiceSuT.addAMedicalVisit(medicalVisit);

        //then
        assertThat(medicalVisitServiceSuT.getMedicalVisits()).isNotEmpty();
        assertThat(medicalVisitServiceSuT.getVisitByDateTimeDoctor(date, time, doctor).
                getPatient().toString()).isEqualTo(patient.toString());
    }

    @Test
    public void should_not_allow_to_add_a_medical_visit_with_incomplete_data() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, time, doctor, null);

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.addAMedicalVisit(medicalVisit));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to add a medical visit, " +
                        "the entered data is incomplete!");
    }

    @Test
    public void should_not_allow_to_add_a_medical_visit_with_incorrect_data() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, LocalTime.of(13, 0), doctor, patient);

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.addAMedicalVisit(medicalVisit));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to add a medical visit, " +
                        "the entered data is incorrect!");
    }

    @Test
    public void should_delete_a_medical_visit_successfully() {
        //given
        int id = medicalVisitServiceSuT.getMedicalVisits().get(0).getId();
        MedicalVisit md = medicalVisitServiceSuT.getMedicalVisits().get(0);

        //when
        medicalVisitServiceSuT.deleteMedicalVisit(id);

        //then
        assertThat(medicalVisitServiceSuT.getMedicalVisits().contains(md)).isEqualTo(false);
    }

    @Test
    public void should_not_allow_to_delete_a_medical_visit_with_with_a_non_existent_id() {
        //given
        int id = -1;

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.deleteMedicalVisit(id));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to delete a medical visit with " +
                        "the given id!");
    }

    @Test
    public void should_cancel_a_medical_visit_successfully() {
        //given
        medicalVisitServiceSuT.addAMedicalVisit(new MedicalVisit(date, time, doctor, patient));
        int id = medicalVisitServiceSuT.getVisitByDateTimeDoctor(date, time, doctor).getId();

        //when
        medicalVisitServiceSuT.cancelMedicalVisit(id);

        //then
        assertThat(medicalVisitServiceSuT.getById(id).getPatient()).isNull();
    }

    @Test
    public void should_not_allow_to_cancel_a_medical_visit_with_with_a_non_existent_id() {
        //given
        int id = -1;

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.cancelMedicalVisit(id));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to cancel a medical visit with " +
                        "the given id!");
    }
}