package com.company;

import com.company.Validators.ValidateType;
import com.company.Validators.Validator;

import java.text.ParseException;
import java.util.*;

import static com.company.Command.*;
import static com.company.Validators.ValidateType.*;
import static com.company.cmd.GUIController.*;
import static com.company.Utils.DateUtils.*;

public class Main {
    private static Scanner scan = initScanner();
    private static School school = new School();

    public static void main(String[] args) throws ParseException {
        openFirstApplicationWindow();
        readMainOption();
    }

    private static void readMainOption() throws ParseException {
        int optionNumber = -1;
        do {
            optionNumber = getOptionNumber();
            if(optionNumber == 3) break;
            else if(optionNumber > 0 && optionNumber < 3) {
                if(optionNumber == 1) gotoManageStudentWindow();
                else gotoManageLecturerWindow();
                openFirstApplicationWindow();
            }
            else informInvalidNumberInput();
        } while(optionNumber != 3);
    }

    private static void gotoManageStudentWindow() throws ParseException {
        openManageStudentWindow();
        readManageStudentOption();
    }

    private static void readManageStudentOption() throws ParseException {
        int optionNumber = -1;
        do {
            optionNumber = getOptionNumber();
            if (optionNumber == 6) {
                return;
            } else if (optionNumber > 0 && optionNumber < 6){
                switch (optionNumber){
                    case 1: addNewStudent(); break;
                    case 2: viewAllStudents(); break;
                    case 3: searchStudents(); break;
                    case 4: deleteStudents(); break;
                    default: updateStudent(); break;
                }
                //Anh vừa phát hiện ra một lỗi nguy hiểm, nếu để như lúc đầu là gotoManageStudentWindow
                //Nó sẽ bị sai - em cứ thử sẽ thấy - bấm search students sau đó back to main menu sẽ bị lỗi
                openManageStudentWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }

    private static void updateStudent() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        Student student = new Student();
        for (Student s: school.viewStudent()){
            if (s.getId().equals(id)){
                student = s;
            }
        }
        school.updateStudent(id, student);
    }

    private static void deleteStudents() {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        school.deleteStudent(id);
    }

    private static void searchStudents() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        List<Student> students = school.searchStudent(name);
        viewSearchedStudents(students);
    }

    private static void viewSearchedStudents(List<Student> students) {
        for (Student s: students){
            s.displayInfo();
        }
    }

    private static void viewAllStudents() {
        List<Student> students = school.viewStudent();
        for (Student s: students){
            s.displayInfo();
        }
    }

    private static void addNewStudent() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID, STUDENT_ID_VALIDATE_TYPE);
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        Date dob = parseDate(input(ENTER_DOB, DATE_VALIDATE_TYPE));
        String email = input(ENTER_EMAIL, EMAIL_VALIDATE_TYPE);
        String phone = input(ENTER_PHONE, PHONE_VALIDATE_TYPE);
        String addr = input(ENTER_ADDRESS, NO_VALIDATE_TYPE);
        String batch = input(ENTER_BATCH, NO_VALIDATE_TYPE);
        Student student = new Student(id, name, dob, email, phone, addr, batch);
        school.addStudent(student);
    }

    private static void skipCurrentLineRead() {
        scan.nextLine();
    }

    private static String input(String requiredContent, ValidateType type) {
        String input;
        do {
            write(requiredContent);
            input = scan.nextLine();
        } while(!Validator.isSuccessfullyValidated(input, type));
        return input;
    }

    private static void gotoManageLecturerWindow() throws ParseException {
        openManageLecturerWindow();
        readManageLecturerOption();
    }

    private static void readManageLecturerOption() throws ParseException {
        int optionNumber = -1;
        do {
            optionNumber = getOptionNumber();
            if (optionNumber == 6) {
                return;
            } else if (optionNumber > 0 && optionNumber < 6){
                switch (optionNumber){
                    case 1: addNewLecturer(); break;
                    case 2: viewAllLecturers(); break;
                    case 3: searchLecturers(); break;
                    case 4: deleteLecturers(); break;
                    default: updateLecturer(); break;
                }
                openManageLecturerWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }



    private static void updateLecturer() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        Lecturer lecturer = new Lecturer();
        for (Lecturer l: school.viewLecturer()){
            if (l.getId().equals(id)){
                lecturer = l;
            }
        }
        school.updateLecturer(id, lecturer);
    }

    private static void deleteLecturers() {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        school.deleteLecturer(id);
    }

    private static void searchLecturers() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        List<Lecturer> lecturers = school.searchLecturer(name);
        viewSearchedLecturer(lecturers);
    }

    private static void viewSearchedLecturer(List<Lecturer> lecturers) {
        for (Lecturer l: lecturers){
            l.displayInfo();
        }
    }

    private static void viewAllLecturers() {
        List<Lecturer> lecturers = school.viewLecturer();
        for (Lecturer l: lecturers){
            l.displayInfo();
        }
    }

    private static void addNewLecturer() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID, LECTURER_ID_VALIDATE_TYPE);
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        Date dob = parseDate(input(ENTER_DOB, DATE_VALIDATE_TYPE));
        String email = input(ENTER_EMAIL, EMAIL_VALIDATE_TYPE);
        String phone = input(ENTER_PHONE, PHONE_VALIDATE_TYPE);
        String addr = input(ENTER_ADDRESS, NO_VALIDATE_TYPE);
        String dept = input(ENTER_DEPARTMENT, NO_VALIDATE_TYPE);
        Lecturer lecturer = new Lecturer(id, name, dob, email, phone, addr, dept);
        school.addLecturer(lecturer);
    }

    private static int getOptionNumber() {
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }

    }

    private static Scanner initScanner() {
        return new Scanner(System.in);
    }
}
