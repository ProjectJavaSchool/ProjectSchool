package com.company;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student student = new Student("GT53638", "Jason", new Date(), "jason@email.com", "03423454567", "fgfccv", "lala");
        Lecturer lecturer = new Lecturer("527847382", "Lily", new Date(), "lily@email.com", "04735867385", "hdfkvb", "CS");
        School school;

        Command command = new Command();
        System.out.println("=======================\n");
        System.out.println("\t1.  " + command.ManageStudents);
        System.out.println("\t2.  " + command.ManageLecturers);
        System.out.println("\t3.  " + command.Exit);
        System.out.println("\n=======================");
        System.out.println("\nPlease choose: ");

        String input = scan.nextLine();
        switch (input){
            case "1" : {
                break;
            }

            case "2" : {
                break;
            }

            default: break;
        }
    }
}
