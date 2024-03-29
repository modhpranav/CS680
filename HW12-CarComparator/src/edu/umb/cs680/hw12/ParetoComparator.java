package edu.umb.cs680.hw12;


import java.util.*;

public class ParetoComparator implements Comparator<Car>{

    public ParetoComparator(ArrayList<Car> cars) {
        for(Car c: cars){
            c.setCars(cars);
        }
    }

    public int compare(Car car1, Car car2){
        return Math.min(car2.getDominationCount(), car1.getDominationCount());
    }
}
