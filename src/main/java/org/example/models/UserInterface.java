package org.example.models;

import org.example.models.Doctor;
import org.example.models.MedicalVisit;
import org.example.models.Patient;

import java.util.List;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class UserInterface {
    public void mainMenu() {
        System.out.println("(1)Doctor or (2)Patient ?");
    }

    public void chooseUser() {
        System.out.println("Enter your id");
    }

    public void actionsMenudoctor() {
        System.out.println("1. Add visit date.");
        System.out.println("2. Delete visit.");
        System.out.println("3. Cancel visit.");
        System.out.println("4. Review all visits");
    }

    public void actionsMenupatient() {
        System.out.println("1. Review possible dates of visit");
        System.out.println("2. Reserve a visit");
        System.out.println("3. Search for possible visit dates");
    }

    public int getValue() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choice?");
        int number = scan.nextInt();
        return number;
    }

    public void Paclist(List<Patient> patients) {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i).toString());
        }
    }

    public void Doclist(List<Doctor> Mds) {
        for (int i = 0; i < Mds.size(); i++) {
            System.out.println(Mds.get(i).toString());
        }
    }

    public void Visitlist(List<Doctor> Mds, List<Patient> patients, List<MedicalVisit> visits, int docID, boolean isDoctor) {
        for (int i = 0; i < visits.size(); i++) {
            if (docID == visits.get(i).getDoctorId()) {
                System.out.println(visits.get(i).toString());
            }
        }
    }


    public void run(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        mainMenu();
        switch (getValue()) {
            case 1: {
                doctorPath(patients, Mds, visits);
                break;
            }
            default: {
                patientPath(patients, Mds, visits);
            }


        }

    }

    public void setVisit(List<Patient> patients, List<MedicalVisit> visits, int ID, Boolean isDoctor) {

        System.out.println("Select a month");
        int month = getValue();
        System.out.println("Select a day");
        int day = getValue();
        System.out.println("Select a hour");
        int hour = getValue();
        System.out.println("Select a min");
        int min = getValue();
        if (isDoctor ==true) {
            System.out.println("Enter patients id");
            int sickOne = getValue();
            MedicalVisit tempvisit = new MedicalVisit(visits.size() + 1, ID, sickOne, month, day, hour, min, VisitStatus.ACTIVE);
            visits.add(tempvisit);
        }
        if (isDoctor== false){
            System.out.println("Enter patients/Your id");
            int sickOne = getValue();
            System.out.println("Enter Your MD id");
            int docID = getValue();
            MedicalVisit tempvisit = new MedicalVisit(visits.size() + 1, docID, sickOne, month, day, hour, min, VisitStatus.ACTIVE);
            visits.add(tempvisit);
        }
        System.out.println("done.");
    }

    private void doctorPath(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        while (true) {
            boolean isDoctor = true;
            Doclist(Mds);
            chooseUser();
            int docID = getValue();
            Visitlist(Mds, patients, visits, docID, isDoctor);
            actionsMenudoctor();

            switch (getValue()) {
                case 1: {
                    setVisit(patients, visits, docID, isDoctor);
                    break;
                }
                case 2: {
                    int pointer = 2;
                    deleteVisit(patients, visits, docID, pointer);
                    break;
                }
                case 3: {
                    int pointer = 3;
                    deleteVisit(patients, visits, docID, pointer);
                    break;
                }
                default: {
                    Visitlist(Mds, patients, visits, docID, isDoctor);
                }

            }

        }
    }
    private void patientPath(List<Patient> patients, List<Doctor> Mds, List<MedicalVisit> visits) {
        while (true) {
            boolean isDoctor = false;
            Paclist(patients);
            chooseUser();
            int docID = getValue();
            Visitlist(Mds, patients, visits, docID, isDoctor);
            actionsMenudoctor();

            switch (getValue()) {
                case 1: {
                    setVisit(patients, visits, docID, isDoctor);
                    break;
                }
                case 2: {
                    int pointer = 2;
                    deleteVisit(patients, visits, docID, pointer);
                    break;
                }
                case 3: {
                    int pointer = 3;
                    deleteVisit(patients, visits, docID, pointer);
                    break;
                }
                default: {
                    Visitlist(Mds, patients, visits, docID, isDoctor);
                }

            }

        }
    }

    private void deleteVisit(List<Patient> patients, List<MedicalVisit> visits, int docID, int pointer) {
        System.out.println("Enter visit id to delete/cancel");
        int visitId = getValue();
        if (pointer == 2) {
            visits.get(visitId).setStatus(VisitStatus.CANCELED);
        }
        if (pointer == 3) {
            visits.get(visitId).setStatus(VisitStatus.DELETED);
        }
    }

}

