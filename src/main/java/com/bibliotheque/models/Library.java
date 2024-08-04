package com.bibliotheque.models;

public class Library {
    private String email;
    private String password;
    private String confirmPassword;

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
}
