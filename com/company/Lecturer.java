package com.company;

import java.util.Date;

public class Lecturer extends PersonInSchool {
    //tuong tu Student nhe
    String dept;

    void set(String id, String name, Date dob, String email, String phone, String addr, String dept){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
        this.dept = dept;
    }
}
