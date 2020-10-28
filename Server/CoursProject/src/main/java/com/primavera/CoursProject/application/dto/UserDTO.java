package com.primavera.CoursProject.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserDTO {

    private String id;

    @Pattern(regexp = "\\b[A-Z][a-z]{3,}\\b",
            message = "Name must stat with capital letters")
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Pattern(regexp = "\\b[A-Z][a-z]{3,}\\b",
            message = "Second name must stat with capital letters")
    @NotBlank(message = "Second name cannot be blank")
    @NotNull(message = "Second name cannot be null")
    private String secondName;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b",
            message = "Email must look like an email")
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    private String password;
    private String phoneNumber;
    private Date birthday;

    private String country;
    private String city;
    private String homeAddress;

    public UserDTO() {

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
}
