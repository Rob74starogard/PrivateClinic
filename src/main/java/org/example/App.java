package org.example;

import org.example.models.*;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        UserInterface mainLoop = new UserInterface();

        while (true) {

            mainLoop.run();

            Scanner choice = new Scanner(System.in);
            System.out.println("Leave application?(Y/N)");
            String a = choice.nextLine();
            if (a.equals("Y")) {
                System.exit(0);
            }
        }
    }
}
