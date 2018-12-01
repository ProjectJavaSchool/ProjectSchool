package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.Command.*;

public class Main {
    private static Scanner scan = initScanner();
    private static School school = new School();

    public static void main(String[] args) throws ParseException {
        Student student = new Student("GT53638", "Jason", new Date(), "jason@email.com", "03423454567", "fgfccv", "lala");
        Lecturer lecturer = new Lecturer("98375939", "Lily", new Date(), "lily@email.com", "08457293857", "asgler", "lolo");
        school.addStudent(student);
        school.addLecturer(lecturer);

        openFirstApplicationWindow();
        readMainOption();
    }

    private static void readMainOption() throws ParseException {
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

    private static void gotoMangeStudentWindow() throws ParseException {
        openManageStudentWindow();
        readManageStudentOption();
    }

    private static void readManageStudentOption() throws ParseException {
        int optionNumber = -1;
        do {
            optionNumber = getOptionNumber();
            if (optionNumber == 6) {
                openFirstApplicationWindow();
                readMainOption();
                break;
            } else if (optionNumber > 0 && optionNumber < 6){
                if (optionNumber == 1) {
                    addNewStudent();
                    openManageStudentWindow();
                    readManageStudentOption();
                } else if (optionNumber == 2) {
                    viewAllStudents();
                    openManageStudentWindow();
                    readManageStudentOption();
                } else if (optionNumber == 3) {
                    searchStudents();
                    openManageStudentWindow();
                    readManageStudentOption();
                } else if (optionNumber == 4){
                    deleteStudents();
                    openManageStudentWindow();
                    readManageStudentOption();
                } else {
                    updateStudent();
                    openManageStudentWindow();
                    readManageStudentOption();
                }
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }

    private static void updateStudent() throws ParseException {
        String id = inputId();
        Student student = new Student();
        for (Student s: school.viewStudent()){
            if (s.getId().equals(id)){
                student = s;
            }
        }
        school.updateStudent(id, student);
    }

    private static void deleteStudents() {
        String id = inputId();
        school.deleteStudent(id);
    }

    private static void searchStudents() {
        String name = inputName();
        List<Student> students = school.searchStudent(name);
        viewSearchedStudents(students);
    }

    private static void viewSearchedStudents(List<Student> students) {
        for (Student s: students){
            viewStudentInfo(s);
        }
    }

    private static void viewAllStudents() {
        List<Student> students = school.viewStudent();
        for (Student s: students){
            viewStudentInfo(s);
        }
    }

    private static void viewStudentInfo(Student s) {
        write(ID); writeln(s.getId());
        write(NAME); writeln(s.getName());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dob = dateFormat.format(s.getDob());
        write(DOB); writeln(dob);
        write(EMAIL); writeln(s.getEmail());
        write(PHONE); writeln(s.getPhone());
        write(ADDRESS); writeln(s.getAddr());
        write(BATCH); writeln(s.getBatch());
        write(BLANK_LINE);
    }

    private static void addNewStudent() {
        String id = inputId();
        String name = inputName();
        Date dob = inputDob();
        String email = inputEmail();
        String phone = inputPhone();
        String addr = inputAddress();
        String batch = inputBatch();
        Student student = new Student(id, name, dob, email, phone, addr, batch);
        school.addStudent(student);
    }

    private static String inputBatch() {
        write(ENTER_BATCH);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputBatch();
        }
    }

    private static String inputAddress() {
        write(ENTER_ADDRESS);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputAddress();
        }
    }

    private static String inputPhone() {
        write(ENTER_PHONE);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputPhone();
        }
    }

    private static String inputEmail() {
        write(ENTER_EMAIL);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputEmail();
        }
    }

    private static Date inputDob() {
        write(ENTER_DOB);
        return new Date();
    }

    private static String inputName() {
        write(ENTER_NAME);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputName();
        }
    }

    private static String inputId() {
        write(ENTER_ID);
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return inputId();
        }
    }

    private static void openManageStudentWindow() {
        writeln(SEPERATOR);
        writeln(ADD_NEW_STUDENT);
        writeln(VIEW_ALL_STUDENTS);
        writeln(SEARCH_STUDENTS);
        writeln(DELETE_STUDENTS);
        writeln(UPDATE_STUDENT);
        writeln(BACK_TO_MAIN_MENU);
        writeln(SEPERATOR);
        write(ENTER_YOUR_OPTION);
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
                openFirstApplicationWindow();
                readMainOption();
            } else if (optionNumber > 0 && optionNumber < 6){
                if (optionNumber == 1) {
                    addNewLecturer();
                } else if (optionNumber == 2) {
                    viewAllLecturers();
                } else if (optionNumber == 3) {
                    searchLecturers();
                } else if (optionNumber == 4){
                    deleteLecturers();
                } else {
                    updateLecturer();
                }
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }

    private static void openManageLecturerWindow() {
        writeln(SEPERATOR);
        writeln(ADD_NEW_LECTURER);
        writeln(VIEW_ALL_LECTURERS);
        writeln(SEARCH_LECTURERS);
        writeln(DELETE_LECTURERS);
        writeln(UPDATE_LECTURER);
        writeln(BACK_TO_MAIN_MENU);
        write(ENTER_YOUR_OPTION);
    }

    private static void updateLecturer() {
    }

    private static void deleteLecturers() {
    }

    private static void searchLecturers() {
    }

    private static void viewAllLecturers() {
    }

    private static void addNewLecturer() {
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
