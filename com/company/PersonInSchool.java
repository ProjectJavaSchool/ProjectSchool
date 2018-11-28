package com.company;

import org.omg.CORBA.portable.IDLEntity;

import java.util.Date;

//Class nay abstract nha em!!
public abstract class PersonInSchool {
//public class PersonInSchool {

    //cac bien cua em phai dung private nhe, neu em de nhu vay thi khong nen.
    private String id;
    //vi bien nay cua em private nen em can co getter va setter
    //setter la de em set cai gia tri vao bien do
    public void setId(String id) {
        this.id = id;
    }
    //getter la de em lay gia tri do ra
    public String getId() {
        return this.id;
    }

    //tuong tu cho may cai duoi nha, ly do tai sao thi em co the google, neu van k hieu thi hoi anh
    String name;
    Date dob;
    String email;
    String phone;
    String addr;

    //em can them mot cai constructor nua

    public PersonInSchool(String id, String name, Date dob, String email, String phone, String addr) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
    }
}
