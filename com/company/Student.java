package com.company;

import java.util.Date;

public class Student extends PersonInSchool {
    String batch;

    void set(String id, String name, Date dob, String email, String phone, String addr, String batch){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
        this.batch = batch;
    }
}
