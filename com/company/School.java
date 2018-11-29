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
            if (s.getName().equals(name)){
                searchedStud.add(s);
            }
        }
        return searchedStud;
    }

    void deleteStudent(String id){
        for (Student s: students){
            if (s.getId().equals(id)){
                students.remove(s);
            }
        }
    }

    void updateStudent(String id, Student stud) throws ParseException {
        for (Student s: students){
            if (s.getId().equals(id)){
                String input;
                System.out.println(s.getId());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setId(input);
                }
                System.out.println(s.getName());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setName(input);
                }
                System.out.println(s.getDob());
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (!input.equals("")){
                    s.setDob(dob_input);
                }
                System.out.println(s.getEmail());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setEmail(input);
                }
                System.out.println(s.getPhone());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setPhone(input);
                }
                System.out.println(s.getAddr());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setAddr(input);
                }
                System.out.println(s.getBatch());
                input = scan.nextLine();
                if (!input.equals("")){
                    s.setBatch(input);
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
            if (l.getName().equals(name)){
                searchedLect.add(l);
            }
        }
        return searchedLect;
    }

    void deleteLecturer(String id){
        for (Student s: students){
            if (s.getId().equals(id)){
                students.remove(s);
            }
        }
    }

    void updateLecturer(String id, Lecturer lect) throws ParseException {
        for (Lecturer l: lecturers) {
            if (l.getId().equals(id)) {
                String input;
                System.out.println(l.getId());
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.setId(input);
                }
                System.out.println(l.getName());
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.setName(input);
                }
                System.out.println(l.getDob());
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (!input.equals("")) {
                    l.setDob(dob_input);
                }
                System.out.println(l.getEmail());
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.setEmail(input);
                }
                System.out.println(l.getPhone());
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.setPhone(input);
                }
                System.out.println(l.getAddr());
                input = scan.nextLine();
                if (!input.equals("")) {
                    l.setAddr(input);
                }
                System.out.println(l.getDept());
                if (!input.equals("")) {
                    l.setDept(input);
                }
            }
        }
    }
}
