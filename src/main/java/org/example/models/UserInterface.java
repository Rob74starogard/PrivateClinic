package org.example.models;

import org.example.models.Doctor;
import org.example.models.MedicalVisit;
import org.example.models.Patient;

import java.util.List;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class UserInterface {
    UInterfaceservices action = new UInterfaceservices();

    public void run(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        action.mainMenu();
        switch (action.getValue()) {
            case 1: {
                doctorPath(patients, Mds, visits);
                break;
            }
            default: {
                patientPath(patients, Mds, visits);
            }
        }
    }

    boolean isDoctor;

    public void run2(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        action.mainMenu();
        if (action.getValue() == 1) {
            isDoctor = true;
        } else {
            isDoctor = false;
        }
        userPath(patients, Mds, visits, isDoctor);
    }

    private void userPath(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits, boolean isDoctor) {
        boolean running = true;
        while (running == true) {
            if (isDoctor == true) {
                action.Doclist(Mds);
                action.chooseUser();
                int docID = action.getValue();
                action.Visitlist(Mds, patients, visits, docID, isDoctor);
                action.Menudoctor();
            }
            if (isDoctor == false) {
                action.Paclist(patients);
                int docID = action.getValue();
                action.Visitlist(Mds, patients, visits, docID, isDoctor);
                action.Menupatient();
            }

        }

    }

    public  void doctorPath(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        boolean isRunning = true;
        while (isRunning) {
            boolean isDoctor = true;
            action.Doclist(Mds);
            action.chooseUser();
            int userId = action.getValue();
            action.Visitlist(Mds, patients, visits, userId, isDoctor);
            action.Menudoctor();

            switch (action.getValue()) {
                case 1: {
                    action.setVisit(Mds,patients, visits, userId, isDoctor);
                    break;
                }
                case 2: {
                    int pointer = 2;
                    action.manageVisit(patients, visits, userId, pointer);
                    break;
                }
                case 3: {
                    int pointer = 3;
                    action.manageVisit(patients, visits, userId, pointer);
                    break;
                }
                default: {
                    action.Visitlist(Mds, patients, visits, userId, isDoctor);
                    isRunning = false;
                }

            }

        }
    }

    public void patientPath(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        boolean isRunning = true;
        action.Paclist(patients);
        action.chooseUser();
        int userId = action.getValue();

        while (isRunning) {
            boolean isDoctor = false;
            //action.Visitlist(Mds, patients, visits, userId, isDoctor);
            action.Menupatient();
            switch (action.getValue()) {
                case 1: {

                    action.Visitlist(Mds, patients, visits, userId, isDoctor);
                    break;
                }
                case 2: {
                    action.setVisit(Mds,patients, visits, userId, isDoctor);
                    break;
                }
                case 3: {
                    int pointer = 3;
                    action.manageVisit(patients, visits, userId, pointer);
                    break;
                }
                default: {
                    action.Visitlist(Mds, patients, visits, userId, isDoctor);
                    isRunning = false;
                }

            }

        }
    }


}
