package edu.umb.cs680.hw10.fs.SecurityJob;

public class User {
    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getPass(){
        return this.password;
    }

    public static void main(String[] args){}
}
