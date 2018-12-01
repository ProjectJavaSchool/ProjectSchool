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
                    //nó sẽ chạy tiếp cái update student này :)
                    default: updateStudent(); break;
                }
                gotoManageStudentWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }

    private static void updateStudent() throws ParseException {
        skipCurrentLineRead();
        write(ENTER_ID); String id = input();
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
        write(ENTER_ID); String id = input();
        school.deleteStudent(id);
    }

    private static void searchStudents() {
        skipCurrentLineRead();
        write(ENTER_NAME); String name = input();
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
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String dob = dateFormat.format(s.getDob());
        write(DOB); writeln(dob);
        write(EMAIL); writeln(s.getEmail());
        write(PHONE); writeln(s.getPhone());
        write(ADDRESS); writeln(s.getAddr());
        write(BATCH); writeln(s.getBatch());
        write(BLANK_LINE);
    }

    private static void addNewStudent() throws ParseException {
        skipCurrentLineRead();
        write(ENTER_ID); String id = input();
        write(ENTER_NAME); String name = input();
        write(ENTER_DOB); Date dob = parseDate(input());
        write(ENTER_EMAIL); String email = input();
        write(ENTER_PHONE); String phone = input();
        write(ENTER_ADDRESS); String addr = input();
        write(ENTER_BATCH); String batch = input();
        Student student = new Student(id, name, dob, email, phone, addr, batch);
        school.addStudent(student);
    }

    private static void skipCurrentLineRead() {
        scan.nextLine();
    }

    private static String input() {
        try {
            return scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return input();
        }
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
                gotoManageLecturerWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }



    private static void updateLecturer() throws ParseException {
        skipCurrentLineRead();
        write(ENTER_ID); String id = input();
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
        write(ENTER_ID); String id = input();
        school.deleteLecturer(id);
    }

    private static void searchLecturers() {
        skipCurrentLineRead();
        write(ENTER_NAME); String name = input();
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
        write(ID); writeln(l.getId());
        write(NAME); writeln(l.getName());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dob = dateFormat.format(l.getDob());
        writeln(dob);
        write(EMAIL); writeln(l.getEmail());
        write(PHONE); writeln(l.getPhone());
        write(ADDRESS); writeln(l.getAddr());
        write(DEPARTMENT); writeln(l.getDept());
        write(BLANK_LINE);
    }

    private static void addNewLecturer() throws ParseException {
        skipCurrentLineRead();
        write(ENTER_ID); String id = input();
        write(ENTER_NAME); String name = input();
        write(ENTER_DOB); Date dob = parseDate(input());
        write(ENTER_EMAIL); String email = input();
        write(ENTER_PHONE); String phone = input();
        write(ENTER_ADDRESS); String addr = input();
        write(ENTER_DEPARTMENT); String dept = input();
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
