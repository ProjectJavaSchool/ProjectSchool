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
        if (!isExistedStudentID(id)){
            writeln(ID_DOES_NOT_EXIST);
            return;
        }
        for (Student s: school.viewStudent()){
            if (s.getId().equals(id)){
                student = s;
                break;
            }
        }
        school.updateStudent(id, student);
        writeln(STUDENTS_UPDATED_INFO);
        student.displayInfo();
    }

    private static void deleteStudents() {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        if (!isExistedStudentID(id)){
            writeln(ID_DOES_NOT_EXIST);
            return;
        }
        school.deleteStudent(id);
        writeln(STUDENTS_DELETED);
    }

    private static void searchStudents() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        List<Student> students = school.searchStudent(name);
        if (students.size()==0){
            writeln(NO_SEARCHED_STUDENTS);
            return;
        }
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
        String id = "";
        while (true){
            id = input(ENTER_ID, STUDENT_ID_VALIDATE_TYPE);
            if (!isExistedStudentID(id)){
                break;
            }
            writeln(ID_EXISTS);
        }
        String name = input(ENTER_NAME, NAME_VALIDATE_TYPE);
        Date dob = parseDate(input(ENTER_DOB, DATE_VALIDATE_TYPE));
        String email = input(ENTER_EMAIL, EMAIL_VALIDATE_TYPE);
        String phone = input(ENTER_PHONE, PHONE_VALIDATE_TYPE);
        String addr = input(ENTER_ADDRESS, NO_VALIDATE_TYPE);
        String batch = input(ENTER_BATCH, NO_VALIDATE_TYPE);
        Student student = new Student(id, name, dob, email, phone, addr, batch);
        school.addStudent(student);
        writeln(STUDENT_ADDED);
    }

    private static void skipCurrentLineRead() {
        scan.nextLine();
    }

    private static String input(String requiredContent, ValidateType type) {
        String input;
        do {
            write(requiredContent);
            input = scan.nextLine();
            if (type.equals(NO_VALIDATE_TYPE)) {
                return input;
            }
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
        if (!isExistedLecturerID(id)){
            writeln(ID_DOES_NOT_EXIST);
            return;
        }
        for (Lecturer l: school.viewLecturer()){
            if (l.getId().equals(id)){
                lecturer = l;
            }
        }
        school.updateLecturer(id, lecturer);
        writeln(LECTURERS_UPDATED_INFO);
        lecturer.displayInfo();
    }

    private static void deleteLecturers() {
        skipCurrentLineRead();
        String id = input(ENTER_ID, NO_VALIDATE_TYPE);
        if (!isExistedLecturerID(id)){
            writeln(ID_DOES_NOT_EXIST);
            return;
        }
        school.deleteLecturer(id);
        writeln(LECTURERS_DELETED);
    }

    private static void searchLecturers() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME, NO_VALIDATE_TYPE);
        List<Lecturer> lecturers = school.searchLecturer(name);
        if (lecturers.size()==0){
            writeln(NO_SEARCHED_LECTURERS);
            return;
        }
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
        String id = "";
        while (true){
            id = input(ENTER_ID, LECTURER_ID_VALIDATE_TYPE);
            if (!isExistedLecturerID(id)){
                break;
            }
            writeln(ID_EXISTS);
        }
        String name = input(ENTER_NAME, NAME_VALIDATE_TYPE);
        Date dob = parseDate(input(ENTER_DOB, DATE_VALIDATE_TYPE));
        String email = input(ENTER_EMAIL, EMAIL_VALIDATE_TYPE);
        String phone = input(ENTER_PHONE, PHONE_VALIDATE_TYPE);
        String addr = input(ENTER_ADDRESS, NO_VALIDATE_TYPE);
        String dept = input(ENTER_DEPARTMENT, NO_VALIDATE_TYPE);
        Lecturer lecturer = new Lecturer(id, name, dob, email, phone, addr, dept);
        school.addLecturer(lecturer);
        writeln(LECTURER_ADDED);
    }

    private static int getOptionNumber() {
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }

    private static boolean isExistedStudentID(String id){
        for (Student s: school.students){
            if (id.equals(s.getId())){
                return true;
            }
        }
        return false;
    }

    private static boolean isExistedLecturerID(String id){
        for (Lecturer l: school.lecturers){
            if (id.equals(l.getId())){
                return true;
            }
        }
        return false;
    }

    private static Scanner initScanner() {
        return new Scanner(System.in);
    }
}
