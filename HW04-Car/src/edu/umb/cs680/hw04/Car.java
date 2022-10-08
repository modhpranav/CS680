package edu.umb.cs680.hw04;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    // Constructor method
    public Car(String make, String model, int mileage, int year, float price){
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    // Getter methods to access Car instance data

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    // main class
    public static void main(String[] args){
    }
}
