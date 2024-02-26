package org.example.models;

import java.util.List;
import java.util.Scanner;

public class UserInterface {


    public void run() {
        mainMenu();
        //logmenu
        switch (getValue()) {
            case 1: {
                doctorPath();
                break;
            }
            default: {
                patientPath();
            }
        }
    }

    public void doctorPath() {
        boolean isRunning = true;
        Menudoctor();
        switch (getValue()) {
            case 1: {
                System.out.println("Option 1");
                break;
            }
            case 2: {
                System.out.println("Option 2");
                break;
            }
            case 3: {
                System.out.println("Option 3");
                break;
            }
            default: {
                System.out.println("Option default");
                isRunning = false;
            }

        }

    }


    public void patientPath() {
        boolean isRunning = true;

        Menupatient();
        int userId = getValue();

        while (isRunning) {
            boolean isDoctor = false;
            //action.Visitlist(Mds, patients, visits, userId, isDoctor);

            switch (getValue()) {
                case 1: {
                    System.out.println("Option 1");
                    break;
                }
                case 2: {
                    System.out.println("Option 2");
                    break;
                }
                case 3: {
                    System.out.println("Option 3");
                    break;
                }
                default: {
                    System.out.println("Default");
                    isRunning = false;
                }

            }

        }
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
    public void mainMenu() {
        System.out.println("(1)Doctor or (2)Patient ?");
    }


}



