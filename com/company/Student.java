package com.company;

import java.util.Date;

public class Student extends PersonInSchool {
    private String batch;

    public Student(){ }

    public Student(String id, String name, Date dob, String email, String phone, String addr, String batch){
        super(id, name, dob, email, phone, addr);
        this.batch = batch;
    }

    public String getBatch(){ return this.batch; }

    public void setBatch(String batch){ this.batch = batch; }
}
