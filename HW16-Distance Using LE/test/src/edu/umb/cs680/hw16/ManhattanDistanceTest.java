package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManhattanDistanceTest {

    @Test
    public void verifyManhattanDistanceTest() throws Exception {
        double expected = 8.0;
        List<Double> p2;
        List<Double> p1 = Arrays.asList(2.0, 3.0, 5.0);
        p2 = Arrays.asList(5.0, 7.0, 6.0);
        assertEquals(expected, Distance.get(
                p1, p2
                , (List<Double>p11,List<Double>p12)->{
                    if (p1.size() != p2.size()){
                        throw new Exception("Size of p1 cannot be more than p2.");
                    }else{
                        double summation = 0.0;
                        for(int i=0; i < p1.size(); i++) {
                            summation += Math.abs( p1.get(i)-p2.get(i) );
                        }
                        return summation;
                    }}));
    }

    @Test
    public void verifySizeTest(){
        List<Double> p2;
        List<Double> p1 = Arrays.asList(3.0, 5.0);
        p2 = Arrays.asList(5.0, 7.0, 6.0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> Distance.get(p1, p2, (List<Double>p11,List<Double>p12)->{
                    if (p1.size() != p2.size()){
                        throw new Exception("Size of p1 cannot be more than p2.");
                    }else{
                        double sumOfSquared = 0.0;
                        for(int i=0; i < p1.size(); i++) {
                            sumOfSquared += Math.pow( p1.get(i)-p2.get(i), 2 );
                        }
                        return Math.sqrt(sumOfSquared);
                    }
                }),
                "Size of P1 greater than P2"
        );
        assertTrue(thrown.getMessage().contains("Size of p1 cannot be more than p2."), "Distance cannot be fetched.");
    }

    @Test
    public void verifyManhattanDistancePointsTest() throws Exception {
        List<List<Double>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0.0, 9.0, 9.0, 38.0, 93.0));
        expected.add(Arrays.asList(9.0, 0.0, 4.0, 35.0, 90.0));
        expected.add(Arrays.asList(9.0, 4.0, 0.0, 31.0, 86.0));
        expected.add(Arrays.asList(38.0, 35.0, 31.0, 0.0, 67.0));
        expected.add(Arrays.asList(93.0, 90.0, 86.0, 67.0, 0.0));
        List<List<Double>> manhattanPoints = new ArrayList<>();
        manhattanPoints.add(Arrays.asList(2.0,3.0,5.0));
        manhattanPoints.add(Arrays.asList(3.0,8.0,2.0));
        manhattanPoints.add(Arrays.asList(5.0,8.0,4.0));
        manhattanPoints.add(Arrays.asList(5.0,25.0,18.0));
        manhattanPoints.add(Arrays.asList(13.0,19.0,71.0));
        System.out.println(
                Arrays.toString(Distance.matrix(manhattanPoints, (List<Double> p1, List<Double> p2) -> {
                    double sum = 0;
                    for (int i = 0; i < p1.size(); i++) {
                        double diff = Math.abs(p1.get(i) - p2.get(i));
                        sum += diff;
                    }
                    return sum;
                }).toArray()));
        assertTrue(Arrays.deepEquals(expected.toArray(),
                    Distance.matrix(manhattanPoints,(List<Double>p1,List<Double>p2)->{
                    double sum = 0;
                    for(int i=0;i<p1.size();i++){
                        double diff = Math.abs(p1.get(i)-p2.get(i));
                        sum+=diff;
                    }
                    return sum;
                    }).toArray()));
    }
}
