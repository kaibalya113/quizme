package com.example.quiz.model;

public class    User {
    private String name;
    private String password;
    private String phNumber;
    private String email;

    public User(String name, String password, String phNumber, String email) {
        this.name = name;
        this.password = password;
        this.phNumber = phNumber;
        this.email = email;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
