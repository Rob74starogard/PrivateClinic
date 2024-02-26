package org.example.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UInterfaceservices {
    public void mainMenu() {
        System.out.println("(1)Doctor or (2)Patient ?");
    }

    public void chooseUser() {
        System.out.println("Enter your id");
    }

    public void Menudoctor() {
        System.out.println("1. Add visit date.");
        System.out.println("2. Delete visit.");
        System.out.println("3. Cancel visit.");
        System.out.println("4. Review all visits");
    }

    public void Menupatient() {
        System.out.println("1. Review Your visits");
        System.out.println("2. Reserve a visit");
        System.out.println("3. Search for possible visit dates");
        System.out.println("4. Leave manu ");
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

    public void Visitlist(List<Doctor> Mds, List<Patient> patients, List<MedicalVisit> visits, int userId, boolean isDoctor) {
        if (isDoctor == true) {
            for (int i = 0; i < visits.size(); i++) {
                if (userId == visits.get(i).getDoctorId()) {
                    System.out.println(visits.get(i).toString());
                }
            }
        }
        for (int i = 0; i < visits.size(); i++) {
            if (userId == visits.get(i).getPatientId() ) {
                System.out.println(visits.get(i).toString());
            }

        }

    }

    public void setVisit(List<Doctor> Mds, List<Patient> patients, List<MedicalVisit> visits, int userId, boolean isDoctor) {

        if (isDoctor == true) {
            System.out.println("Enter Your patient id");
            int sickOne = getValue();
            System.out.println("Enter free row Id");
            int rowId = getValue();
            if (visits.get(rowId - 1).getStatus().equals(VisitStatus.FREE))
            {
                visits.get(rowId - 1).setPatientId(sickOne);
                visits.get(rowId - 1).setStatus(VisitStatus.ACTIVE);
            }
            else {
                System.out.println("Row is not empty");
            }

        }
        if (isDoctor == false) {
            System.out.println("Enter Your MD id");
            int docID = getValue();
            Visitlist( Mds,  patients, visits, docID, true);
            System.out.println("Enter a free row");
            int rowId = getValue();
            if (visits.get(rowId-1).getDoctorId()==docID && visits.get(rowId).getStatus()==VisitStatus.FREE){
                visits.get(rowId-1).setStatus(VisitStatus.ACTIVE);
                visits.get(rowId-1).setPatientId(userId);
            }
            else {
                System.out.println("Row is not empty");
            }
        }
        System.out.println("done.");
    }

    public void manageVisit(List<Patient> patients, List<MedicalVisit> visits, int userId, int pointer) {
        System.out.println("Enter visit id to delete/cancel");
        int visitId = getValue();
        if (pointer == 2) {
            visits.get(visitId - 1).setStatus(VisitStatus.CANCELED);
        }
        if (pointer == 3) {
            visits.get(visitId - 1).setStatus(VisitStatus.DELETED);
        }
    }
    public void cerateVisists(List<MedicalVisit> visits, int docid) {
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        int j = 1;
        for (int i = 0; i < 8; i++) {

            MedicalVisit visit1 = new MedicalVisit(j, 1, 0, month, day, 8 + i, 00, VisitStatus.FREE);
            visits.add(visit1);
            j++;


            MedicalVisit visit2 = new MedicalVisit(j, 1, 0, month, day, 8 + i, 30, VisitStatus.FREE);
            visits.add(visit2);
            j++;

        }
        for (int i = 0; i < 8; i++) {

            MedicalVisit visit1 = new MedicalVisit(j, 2, 0, month, day, 8 + i, 00, VisitStatus.FREE);
            visits.add(visit1);
            j++;


            MedicalVisit visit2 = new MedicalVisit(j, 2, 0, month, day, 8 + i, 30, VisitStatus.FREE);
            visits.add(visit2);
            j++;

        }
    }

}



