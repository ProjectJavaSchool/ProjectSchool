package com.company;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import static com.company.Command.*;

public class Main {
    private static Scanner scan = initScanner();

    public static void main(String[] args) {
        openFirstApplicationWindow();
        readMainOption();


        Student student = new Student();
        student.set("GT53638", "Jason", new Date(), "jason@email.com", "03423454567", "fgfccv", "lala");
        Lecturer lecturer;
        School school;
    }

    private static void readMainOption() {
        int optionNumber = -1;
        do {
            optionNumber = getOptionNumber();
            if(optionNumber == 3) break;
            else if(optionNumber > 0 && optionNumber < 3) {
                if(optionNumber == 1) gotoMangeStudentWindow();
                else gotoManageLecturerWindow();
                openFirstApplicationWindow();
            }
            else informInvalidNumberInput();
        } while(optionNumber != 3);
    }

    private static void gotoMangeStudentWindow() {
    }

    private static void gotoManageLecturerWindow() {
    }

    private static int getOptionNumber() {
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }

    }

    private static void informInvalidNumberInput() {
        writeln(NOT_VALID_NUMBER_INPUT);
        write(ENTER_YOUR_OPTION);
    }

    private static void openFirstApplicationWindow() {
        writeln(SEPERATOR);
        writeln(MANAGE_STUDENTS);
        writeln(MANAGE_LECTURERS);
        writeln(EXIT);
        writeln(SEPERATOR);
        write(ENTER_YOUR_OPTION);
    }

    private static Scanner initScanner() {
        return new Scanner(System.in);
    }
}
