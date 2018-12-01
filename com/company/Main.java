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

public class Main {
    private static Scanner scan = initScanner();
    private static School school = new School();

    public static void main(String[] args) throws ParseException {
//        Student student = new Student("GT53638", "Jason", new Date(), "jason@email.com", "03423454567", "fgfccv", "lala");
//        Lecturer lecturer = new Lecturer("98375939", "Lily", new Date(), "lily@email.com", "08457293857", "asgler", "lolo");
//        school.addStudent(student);
//        school.addLecturer(lecturer);

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
                //em không cần gọi openFirstAppWindow làm gì nữa, chỉ cần return thôi, vì sau khi return nó sẽ openFirstAppliactionWindow mà?
                //coi hàm readMainOption ấy - sau khi sau khúc if else optionNumber == 1 các kiểu, có cái openFirstApplicationWindow() rồi đó.
//                openFirstApplicationWindow();
//                readMainOption();
//                break;
                return;
            } else if (optionNumber > 0 && optionNumber < 6){
                switch (optionNumber){
                    case 1: addNewStudent();
                    case 2: viewAllStudents();
                    case 3: searchStudents();
                    case 4: deleteStudents();
                    default: updateStudent();
                }
                //ủa Thảo ơi sao hai cái này y chang cái gotoManageStudentWindow mà sao k dùng nó luôn, reuse code đi em
                //à haha gotoMangeStudent là cái gì cơ =))
//                openManageStudentWindow();
//                readManageStudentOption();
                gotoManageStudentWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }

    private static void updateStudent() throws ParseException {
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
        write(ENTER_ID); String id = input();
        school.deleteStudent(id);
    }

    private static void searchStudents() {
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dob = dateFormat.format(s.getDob());
        writeln(dob);
        write(EMAIL); writeln(s.getEmail());
        write(PHONE); writeln(s.getPhone());
        write(ADDRESS); writeln(s.getAddr());
        write(BATCH); writeln(s.getBatch());
        write(BLANK_LINE);
    }

    private static void addNewStudent() {
        skipCurrentLineRead();
        //em để ý mấy cái hàm inputId, inputName đồ, nó hao hao giống nhau hem?
        //tìm cách viết nó thành một hàm cho anh coi :))
        //bí thì pm nhé
        write(ENTER_ID); String id = input();
        write(ENTER_NAME); String name = input();
        Date dob = inputDob();
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

    private static Date inputDob() {
        write(ENTER_DOB);
        return new Date();
    }

    private static String input() {
        try {
            //scan.nextLine là nó scan cái line em đang viết đó
            //Trong trường hợp này, ngay sau khi click là nó scan cả cái line em đang đúng đó - tức là nó scan cái Enter your option: 1 gì đó =))
            //trước khi em vào hàm này, scan.nextLine() một lần là được - coi hàm addStudent anh thêm cái hàm skip current line nhé
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
                //tương tự như bên student ha
                return;
            } else if (optionNumber > 0 && optionNumber < 6){
                switch (optionNumber){
                    case 1: addNewLecturer();
                    case 2: viewAllLecturers();
                    case 3: searchLecturers();
                    case 4: deleteLecturers();
                    default: updateLecturer();
                }
                //tương tự Student
//                openManageLecturerWindow();
//                readManageLecturerOption();
                gotoManageLecturerWindow();
            } else {
                informInvalidNumberInput();
            }
        } while (optionNumber != 6);
    }



    private static void updateLecturer() throws ParseException {
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
        write(ENTER_ID); String id = input();
        school.deleteLecturer(id);
    }

    private static void searchLecturers() {
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

    private static void addNewLecturer() {
        skipCurrentLineRead();
        write(ENTER_ID); String id = input();
        write(ENTER_NAME); String name = input();
        Date dob = inputDob();
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
