package com.company;

import java.util.Date;

public class Lecturer extends PersonInSchool {
    private String dept;

    public Lecturer(){ }

    public Lecturer(String id, String name, Date dob, String email, String phone, String addr, String dept){
        super(id, name, dob, email, phone, addr);
        this.dept = dept;
    }

    public void setDept(String dept){ this.dept = dept; }

    public String getDept(){ return this.dept; }
}
