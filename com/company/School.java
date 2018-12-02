package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Command.*;
import static com.company.Command.writeln;
import static com.company.Utils.DateUtils.*;

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
                writeln(ID + stud.getId());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setId(input);
                }
                writeln(NAME + stud.getName());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setName(input);
                }
                writeln(DOB + parseString(stud.getDob()));
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setDob(parseDate(input));
                }
                writeln(EMAIL + stud.getEmail());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setEmail(input);
                }
                writeln(PHONE + stud.getPhone());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setPhone(input);
                }
                writeln(ADDRESS + stud.getAddr());
                input = scan.nextLine();
                if (!input.equals("")){
                    stud.setAddr(input);
                }
                writeln(BATCH + stud.getBatch());
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
        for (Lecturer l: lecturers){
            if (l.getId().equals(id)){
                lecturers.remove(l);
            }
        }
    }

    public void updateLecturer(String id, Lecturer lect) throws ParseException {
                String input;
                writeln(ID + lect.getId());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setId(input);
                }
                writeln(NAME + lect.getName());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setName(input);
                }
                writeln(DOB + parseString(lect.getDob()));
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setDob(parseDate(input));
                }
                writeln(EMAIL + lect.getEmail());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setEmail(input);
                }
                writeln(PHONE + lect.getPhone());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setPhone(input);
                }
                writeln(ADDRESS + lect.getAddr());
                input = scan.nextLine();
                if (!input.equals("")) {
                    lect.setAddr(input);
                }
                writeln(DEPARTMENT + lect.getDept());
                if (!input.equals("")) {
                    lect.setDept(input);
                }
    }
}
