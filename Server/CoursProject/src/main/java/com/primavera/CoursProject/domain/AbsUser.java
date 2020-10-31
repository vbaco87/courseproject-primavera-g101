package com.primavera.CoursProject.domain;

import java.util.Date;
import java.util.UUID;

public abstract class AbsUser {

    private String id;
    private String name;
    private String secondName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date birthday;

    private String country;
    private String city;
    private String homeAddress;

    public AbsUser () {
        id = UUID.randomUUID().toString();
    }

    public AbsUser(String name, String secondName, String email, String password, String phoneNumber, Date birthday, String country, String city, String homeAddress) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.country = country;
        this.city = city;
        this.homeAddress = homeAddress;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setPhone_number(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
