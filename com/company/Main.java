package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.Command.*;
//để sử dụng được GUIController em phải import như thế này, để ý thấy chữ Static chứ!
// Nếu em không có chữ static nó vẫn sẽ chạy nhé, nhưng ở dưới em phải viết kiểu khác.
// Muốn biết thì pm anh nói thêm cho!
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
        String id = input(ENTER_ID);
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
        String id = input(ENTER_ID);
        school.deleteStudent(id);
    }

    private static void searchStudents() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME);
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
        writeln(ID + s.getId());
        writeln(NAME + s.getName());
        writeln(DOB + parseString(s.getDob()));
        writeln(EMAIL + s.getEmail());
        writeln(PHONE + s.getPhone());
        writeln(ADDRESS + s.getAddr());
        writeln(BATCH + s.getBatch());
        writeln(EMPTY);
    }

    private static void addNewStudent() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID);
        String name = input(ENTER_NAME);
        Date dob = parseDate(input(ENTER_DOB));
        String email = input(ENTER_EMAIL);
        String phone = input(ENTER_PHONE);
        String addr = input(ENTER_ADDRESS);
        String batch = input(ENTER_BATCH);
        Student student = new Student(id, name, dob, email, phone, addr, batch);
        school.addStudent(student);
    }

    private static void skipCurrentLineRead() {
        scan.nextLine();
    }

    private static String input(String requiredContent) {
        write(requiredContent);
        return scan.nextLine();
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
        String id = input(ENTER_ID);
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
        String id = input(ENTER_ID);
        school.deleteLecturer(id);
    }

    private static void searchLecturers() {
        skipCurrentLineRead();
        String name = input(ENTER_NAME);
        List<Lecturer> lecturers = school.searchLecturer(name);
        viewSearchedLecturer(lecturers);
    }

    private static void viewSearchedLecturer(List<Lecturer> lecturers) {
        for (Lecturer l: lecturers){
            viewLecturerInfo(l);
        }
    }

    private static void viewAllLecturers() {
        List<Lecturer> lecturers = school.viewLecturer();
        for (Lecturer l: lecturers){
            viewLecturerInfo(l);
        }
    }

    private static void viewLecturerInfo(Lecturer l) {
        skipCurrentLineRead();
        writeln(ID + l.getId());
        writeln(NAME + l.getName());
        writeln(DOB + parseString(l.getDob()));
        writeln(EMAIL + l.getEmail());
        writeln(PHONE + l.getPhone());
        writeln(ADDRESS + l.getAddr());
        writeln(DEPARTMENT + l.getDept());
        writeln(EMPTY);
    }

    private static void addNewLecturer() throws ParseException {
        skipCurrentLineRead();
        String id = input(ENTER_ID);
        String name = input(ENTER_NAME);
        Date dob = parseDate(input(ENTER_DOB));
        String email = input(ENTER_EMAIL);
        String phone = input(ENTER_PHONE);
        String addr = input(ENTER_ADDRESS);
        String dept = input(ENTER_DEPARTMENT);
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
