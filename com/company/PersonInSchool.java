package com.company;

import java.util.Date;

public abstract class PersonInSchool {
    private String id;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    private String addr;

    public PersonInSchool(String id, String name, Date dob, String email, String phone, String addr){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDob(Date dob){
        this.dob = dob;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Date getDob(){
        return dob;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddr(){
        return addr;
    }
}
