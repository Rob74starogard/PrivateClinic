package org.example.domain.model;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatientTest {

    @Test
    public void should_successfully_create_the_patient() {
        //given
        String name = "Zuzanna";
        String surname = "Nowak";
        String nickName = "PatientZN";
        String password = "Pzn2!";
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        String phoneNumber = "777555333";

        //when
        Patient patient = new Patient(name, surname, nickName, password, phoneNumber);
        
        //then
        assertThat(patient.getName()).isNotNull();
        assertThat(patient.getName()).isEqualTo(name);
        assertThat(patient.getSurname()).isNotNull();
        assertThat(patient.getSurname()).isEqualTo(surname);
        assertThat(patient.getNickName()).isNotNull();
        assertThat(patient.getNickName()).isEqualTo(nickName);
        assertThat(patient.getPassword()).isNotNull();
        assertThat(patient.getPassword()).isEqualTo(md5Hex);
        assertThat(patient.getPhoneNumber()).isNotNull();
        assertThat(patient.getPhoneNumber()).isEqualTo(phoneNumber);
    }
}