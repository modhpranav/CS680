package edu.umb.cs680.hw03;

public class SingletonClass {
    private static SingletonClass instance = null;

    private SingletonClass() { }

    public static SingletonClass getInstance( ) {
        if(instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public static void main(String[] args){
    }
}
