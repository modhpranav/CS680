package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private String[] carToStringArray(Car car){
        String[] string_array = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
        return string_array;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String make = "BMW";
        String model = "M1";
        int mileage = 25;
        int year = 2022;
        float price = 25.5F;
        String[] expected_car1_array = {make, model, Integer.toString(year)};
        Car actual_car1_data = new Car(make=make, model=model, mileage=mileage, year=year, price=price);
        assertArrayEquals(expected_car1_array, carToStringArray(actual_car1_data));

        String[] expected_car2_array = {"Toyota", "RAV4", "2018"};
        Car actual_car2_data = new Car(make="Toyota", model="RAV4", mileage=22, year=2018, price=29.7F);
        assertArrayEquals(expected_car2_array, carToStringArray(actual_car2_data));
    }

}
