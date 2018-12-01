package com.company;

import java.util.Date;

import static com.company.Command.*;
import static com.company.Command.EMPTY;
import static com.company.Command.writeln;
import static com.company.Utils.DateUtils.parseString;

public class Lecturer extends PersonInSchool {
    private String dept;

    public Lecturer(){ }

    public Lecturer(String id, String name, Date dob, String email, String phone, String addr, String dept){
        super(id, name, dob, email, phone, addr);
        this.dept = dept;
    }

    public void setDept(String dept){ this.dept = dept; }

    public String getDept(){ return this.dept; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        writeln(DEPARTMENT + this.dept);
        writeln(EMPTY);
    }
}
