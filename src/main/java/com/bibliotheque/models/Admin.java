package com.bibliotheque.models;

public class Admin {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }
}
