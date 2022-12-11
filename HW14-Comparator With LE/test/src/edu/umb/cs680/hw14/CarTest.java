package edu.umb.cs680.hw14;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {

    public static ArrayList<Car> usedCarData;

    @BeforeAll
    public static void createdata(){
      usedCarData = new TestFixtureInitializer().createCarData();
    };

    @Test
    public void verifyMileageComparatorNaturalOrderTest() {
        ArrayList<Float> expected = new ArrayList<>(Arrays.asList(5300f, 6773f, 7200f, 9812f));
        ArrayList<Float> actual = new ArrayList<>();
        Collections.sort(usedCarData, Comparator.comparing(Car :: getMileage, Comparator.naturalOrder()));
        for(Car c : usedCarData){
            actual.add(c.getMileage());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyMileageComparatorReverseOrderTest() {
        ArrayList<Float> expected = new ArrayList<>(Arrays.asList(9812f,7200f,6773f,5300f));
        ArrayList<Float> actual = new ArrayList<>();
        Collections.sort(usedCarData, Comparator.comparing(Car :: getMileage, Comparator.reverseOrder()));
        for(Car c : usedCarData){
            actual.add(c.getMileage());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyPriceComparatorNaturalOrderTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(8000, 9000, 10000, 20000));
        ArrayList<Integer> actual = new ArrayList<>();
        Collections.sort(usedCarData, Comparator.comparing(Car :: getPrice, Comparator.naturalOrder()));
        for(Car c : usedCarData){
            actual.add(c.getPrice());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyPriceComparatorReverseOrderTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(20000,10000,9000,8000));
        ArrayList<Integer> actual = new ArrayList<>();
        Collections.sort(usedCarData, Comparator.comparing(Car :: getPrice, Comparator.reverseOrder()));
        for(Car c : usedCarData){
            actual.add(c.getPrice());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyYearComparatorNaturalOrderTest(){
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2000, 2001, 2002, 2004));
        Collections.sort(usedCarData, Comparator.comparing(Car :: getYear, Comparator.naturalOrder()));
        for(Car c : usedCarData){
            actual.add(c.getYear());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyYearComparatorReverseOrderTest(){
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2004,2002,2001,2000));
        Collections.sort(usedCarData, Comparator.comparing(Car :: getYear, Comparator.reverseOrder()));
        for(Car c : usedCarData){
            actual.add(c.getYear());
        }
        assertEquals(actual, expected);
    }

    @Test
    public void verifyDominationComparatorNaturalOrderTest() {

        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 0, 2, 3));

        for(Car car: usedCarData){
            car.dominationCount(usedCarData, car);
        }
        Collections.sort(usedCarData, Comparator.comparing(Car :: getDominationCount, Comparator.naturalOrder()));
        for(Car c : usedCarData){
            actual.add(c.getDominationCount());
        }
        assertEquals(actual, expected);

    }

    @Test
    public void verifyDominationComparatorReverseOrderTest() {

        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3,2,0,0));

        for(Car car: usedCarData){
            car.dominationCount(usedCarData, car);
        }
        Collections.sort(usedCarData, Comparator.comparing(Car :: getDominationCount, Comparator.reverseOrder()));
        for(Car c : usedCarData){
            actual.add(c.getDominationCount());
        }
        assertEquals(actual, expected);

    }

}