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
    public void should_make_a_doctor_appointment_successfully() {
        //given
        int id = medicalVisitServiceSuT.getMedicalVisits().get(0).getId();

        //when
        medicalVisitServiceSuT.makeADoctorAppointment(id, patient);

        //then
        assertThat(medicalVisitServiceSuT.getMedicalVisits().get(0).getPatient()).isEqualTo(patient);
    }

    @Test
    public void should_not_allow_to_make_a_doctor_appointment_when_an_appointment_is_not_available() {
        //given
        int id = medicalVisitServiceSuT.getMedicalVisits().get(0).getId();
        medicalVisitServiceSuT.makeADoctorAppointment(id, patient);

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.makeADoctorAppointment(id, patient));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, the selected date is not available!");
    }

    @Test
    public void should_add_a_medical_visit_successfully() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, LocalTime.of(9, 30), doctor, null);

        //when
        medicalVisitServiceSuT.addAMedicalVisit(medicalVisit);

        //then
        assertThat(medicalVisitServiceSuT.getMedicalVisits()).isNotEmpty();
        assertThat(medicalVisitServiceSuT.getMedicalVisits().contains(medicalVisit)).isEqualTo(true);
    }

    @Test
    public void should_not_allow_to_add_a_medical_visit_with_incomplete_data() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, time, null, null);

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.addAMedicalVisit(medicalVisit));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to add a medical visit, " +
                        "the entered data is incomplete!");
    }

    @Test
    public void should_not_allow_to_add_a_medical_visit_if_one_already_exists() {
        //given
        MedicalVisit medicalVisit = new MedicalVisit(date, LocalTime.of(8, 0), doctor, null);

        //when
        Throwable thrown = catchThrowable(() -> medicalVisitServiceSuT.addAMedicalVisit(medicalVisit));

        //then
        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Sorry, it is not possible to add a medical visit, the " +
                        "given visit already exists!");
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
        int id = medicalVisitServiceSuT.getMedicalVisits().get(0).getId();
        medicalVisitServiceSuT.makeADoctorAppointment(id, patient);

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