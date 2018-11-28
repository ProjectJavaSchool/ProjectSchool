package com.company;

import java.util.Date;

//cho nay bao loi la tai vi PersonInSchool hien tai khong phai la abstract class nen no khong extend dc :)
//em sua PersonInSchool thanh abstract class la se khong loi nua
public class Student extends PersonInSchool {
    //private
    String batch;

    //bo ham nay di, em hay chuyen qua xai constructor
    void set(String id, String name, Date dob, String email, String phone, String addr, String batch){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
        this.batch = batch;
    }

    public Student(String id, String name, Date dob, String email, String phone, String addr, String batch) {
        //super nay la cai constructor cua PersonInSchool ah
        super(id, name, dob, email, phone, addr);
        this.batch = batch;
    }
}
