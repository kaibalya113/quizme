package com.example.quiz.model;

public class    User {
    private String name;
    private String password;
    private String phNumber;
    private String email;
    private long coins ;

    public User(String name, String password, String phNumber, String email, long coins) {
        this.name = name;
        this.password = password;
        this.phNumber = phNumber;
        this.email = email;
        this.coins = coins;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", email='" + email + '\'' +
                ", coins=" + coins +
                '}';
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
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
