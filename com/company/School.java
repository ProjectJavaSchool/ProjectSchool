package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class School {
    Scanner scan = new Scanner(System.in);
    List<Student> students = new ArrayList<>();
    List<Lecturer> lecturers = new ArrayList<>();

// STUDENTS

    void addStudent(Student stud){
        students.add(stud);
    }

    List<Student> viewStudent(){
        return students;
    }

    List<Student> searchStudent(String name){
        List<Student> searchedStud = new ArrayList<>();
        for (Student s: students){
            if (s.name.equals(name)){
                searchedStud.add(s);
            }
        }
        return searchedStud;
    }

    void deleteStudent(String id){
        for (Student s: students){
            if (s.id.equals(id)){
                students.remove(s);
            }
        }
    }

    void updateStudent(String id, Student stud) throws ParseException {
        for (Student s: students){
            if (s.id == id){
                String input;
                System.out.println(s.id);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.id = input;
                }
                System.out.println(s.name);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.name = input;
                }
                System.out.println(s.dob);
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (!input.equals("")){
                    s.dob = dob_input;
                }
                System.out.println(s.email);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.email = input;
                }
                System.out.println(s.phone);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.phone = input;
                }
                System.out.println(s.addr);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.addr = input;
                }
                System.out.println(s.batch);
                input = scan.nextLine();
                if (!input.equals("")){
                    s.batch = input;
                }
            }
        }
    }

// LECTURERS

    void addLecturer(Lecturer lect){
        lecturers.add(lect);
    }

    List<Lecturer> viewLecturer(){
        return lecturers;
    }

    List<Lecturer> searchLecturer(String name){
        List<Lecturer> searchedLect = new ArrayList<>();
        for (Lecturer l: lecturers){
            if (l.name.equals(name)){
                searchedLect.add(l);
            }
        }
        return searchedLect;
    }

    void deleteLecturer(String id){
        for (Student s: students){
            if (s.id == id){
                students.remove(s);
            }
        }
    }

    void updateLecturer(String id, Lecturer lect) throws ParseException {
        for (Lecturer l: lecturers) {
            if (l.id == id) {
                String input;
                System.out.println(l.id);
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.id = input;
                }
                System.out.println(l.name);
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.name = input;
                }
                System.out.println(l.dob);
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (!input.equals("")) {
                    l.dob = dob_input;
                }
                System.out.println(l.email);
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.email = input;
                }
                System.out.println(l.phone);
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.phone = input;
                }
                System.out.println(l.addr);
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.addr = input;
                }
                System.out.println(l.dept);
                if (!input.equals("")) {
                    l.dept = input;
                }
            }
        }
    }
}
