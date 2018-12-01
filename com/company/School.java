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

    public void addStudent(Student stud){
        students.add(stud);
    }

    public List<Student> viewStudent(){
        return this.students;
    }

    public List<Student> searchStudent(String name){
        List<Student> searchedStud = new ArrayList<>();
        for (Student s: students){
            if (s.getName().equals(name)){
                searchedStud.add(s);
            }
        }
        return searchedStud;
    }

    public void deleteStudent(String id){
        for (Student s: students){
            if (s.getId().equals(id)){
                students.remove(s);
            }
        }
    }

    public void updateStudent(String id, Student stud) throws ParseException {
                String input;
                System.out.println(stud.getId());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setId(input);
                }
                System.out.println(stud.getName());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setName(input);
                }
                System.out.println(stud.getDob());
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/mm/yyyy").parse(input);
                if (!input.equals("")){
                    stud.setDob(dob_input);
                }
                System.out.println(stud.getEmail());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setEmail(input);
                }
                System.out.println(stud.getPhone());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setPhone(input);
                }
                System.out.println(stud.getAddr());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setAddr(input);
                }
                System.out.println(stud.getBatch());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setBatch(input);
                }
    }

// LECTURERS

    public void addLecturer(Lecturer lect){
        lecturers.add(lect);
    }

    public List<Lecturer> viewLecturer(){
        return lecturers;
    }

    public List<Lecturer> searchLecturer(String name){
        List<Lecturer> searchedLect = new ArrayList<>();
        for (Lecturer l: lecturers){
            if (l.getName().equals(name)){
                searchedLect.add(l);
            }
        }
        return searchedLect;
    }

    public void deleteLecturer(String id){
        for (Student s: students){
            if (s.getId().equals(id)){
                students.remove(s);
            }
        }
    }

    public void updateLecturer(String id, Lecturer lect) throws ParseException {
                String input;
                System.out.println(lect.getId());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setId(input);
                }
                System.out.println(lect.getName());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setName(input);
                }
                System.out.println(lect.getDob());
                input = scan.nextLine();
                Date dob_input = new SimpleDateFormat("dd/mm/yyyy").parse(input);
                if (!input.equals("")) {
                    lect.setDob(dob_input);
                }
                System.out.println(lect.getEmail());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setEmail(input);
                }
                System.out.println(lect.getPhone());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setPhone(input);
                }
                System.out.println(lect.getAddr());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setAddr(input);
                }
                System.out.println(lect.getDept());
                if (!input.equals("")) {
                    lect.setDept(input);
                }
    }
}
