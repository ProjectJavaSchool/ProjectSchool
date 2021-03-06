package com.company;

import java.util.Date;

import static com.company.Command.*;
import static com.company.Command.ADDRESS;
import static com.company.Command.writeln;
import static com.company.Utils.DateUtils.parseString;

public abstract class PersonInSchool {
    private String id;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    private String addr;

    public PersonInSchool(){ }

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
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Date getDob(){
        return this.dob;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getAddr(){
        return this.addr;
    }

    public void displayInfo() {
        write(this.id + COLUMN_SEPERATOR);
        write(this.name + COLUMN_SEPERATOR);
        write(parseString(this.dob) + COLUMN_SEPERATOR);
        write(this.email + COLUMN_SEPERATOR);
        write(this.phone + COLUMN_SEPERATOR);
        write(this.addr + COLUMN_SEPERATOR);
    }
}
