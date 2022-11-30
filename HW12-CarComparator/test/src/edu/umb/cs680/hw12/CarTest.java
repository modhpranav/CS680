package edu.umb.cs680.hw12;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {

    public static ArrayList<Car> usedCarData;

    @BeforeAll
    public static void createdata(){
      usedCarData = new TestFixtureInitializer().createCarData();
    };

    @Test
    public void verifyMileageComparatorTest() {
        ArrayList<Float> expected = new ArrayList<>(Arrays.asList(9812f,7200f,6773f,5300f));
        ArrayList<Float> actual = new ArrayList<>();
        Collections.sort(usedCarData, new MileageComparator());
        for(Car c : usedCarData){
            actual.add(c.getMileage());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyPriceComparatorTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(20000,10000,9000,8000));
        ArrayList<Integer> actual = new ArrayList<>();
        Collections.sort(usedCarData, new PriceComparator());
        for(Car c : usedCarData){
            actual.add(c.getPrice());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyYearComparatorTest(){
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2004,2002,2001,2000));
        Collections.sort(usedCarData, new YearComparator());
        for(Car c : usedCarData){
            actual.add(c.getYear());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyDominationComparatorTest() {

        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3,2,0,0));

        for(Car car: usedCarData){
            car.dominationCount(usedCarData, car);
        }
        Collections.sort(usedCarData, new ParetoComparator(usedCarData));
        for(Car c : usedCarData){
            actual.add(c.getDominationCount());
        }
        assertEquals(actual, expected);

    }

}