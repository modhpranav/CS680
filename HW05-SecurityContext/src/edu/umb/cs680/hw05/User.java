package edu.umb.cs680.hw05;

public class User {
    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
