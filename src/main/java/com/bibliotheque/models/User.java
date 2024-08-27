package com.bibliotheque.models;

public class User {

    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String phone;
    private String country;
    private String city;
    private String zip;
    private String street;
    private String house;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public User setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public User setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public User setHouse(String house) {
        this.house = house;
        return this;
    }
}
