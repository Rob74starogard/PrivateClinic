package org.example.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoctorTest {

    @Test
    public void should_successfully_create_the_doctor() {
        //given
        String name = "Maria";
        String surname = "Kowalska";
        String nickName = "DoctorMK";
        String password = "Dmk1!";
        String specialization = "Internal Medicine";

        //when
        Doctor doctor = new Doctor(name, surname, nickName, password, specialization);
        
        //then
        assertThat(doctor.getName()).isNotNull();
        assertThat(doctor.getName()).isEqualTo(name);
        assertThat(doctor.getSurname()).isNotNull();
        assertThat(doctor.getSurname()).isEqualTo(surname);
        assertThat(doctor.getNickName()).isNotNull();
        assertThat(doctor.getNickName()).isEqualTo(nickName);
        assertThat(doctor.getPassword()).isNotNull();
        assertThat(doctor.getPassword()).isEqualTo(password);
        assertThat(doctor.getSpecialization()).isNotNull();
        assertThat(doctor.getSpecialization()).isEqualTo(specialization);
    }
}