package com.bibliotheque.models;

public class Library {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String country;
    private String zip;
    private String city;
    private String street;
    private String house;
    private String phone;

    public String getEmail() {
        return email;
    }

    public Library setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Library setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Library setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getName() {
        return name;
    }

    public Library setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Library setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Library setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Library setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Library setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Library setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Library setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
