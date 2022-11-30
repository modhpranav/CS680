package edu.umb.cs680.hw11;

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
        assertEquals(expected, Distance.get(p1, p2, new Manhattan()));
    }

    @Test
    public void verifySizeTest(){
        List<Double> p2;
        List<Double> p1 = Arrays.asList(3.0, 5.0);
        p2 = Arrays.asList(5.0, 7.0, 6.0);
        Exception thrown = assertThrows(
                Exception.class,
                () -> Distance.get(p1, p2, new Manhattan()),
                "Size of P1 greater than P2"
        );
        assertTrue(thrown.getMessage().contains("Size of p1 cannot be more than p2."), "Distance cannot be fetched.");
    }

    @Test
    public void verifyManhattanDistancePointsTest() throws Exception {
        ArrayList<List<Double>> expected = new ArrayList<List<Double>> ();
        expected.add((Arrays.asList(0.0, 8.0, 9.0)));
        expected.add(Arrays.asList(8.0, 0.0, 7.0));
        expected.add(Arrays.asList(9.0, 7.0, 0.0));
        ArrayList points = new ArrayList<Double>();
        List<Double> p1 = Arrays.asList(2.0, 3.0, 5.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0, 6.0);;
        List<Double> p3 = Arrays.asList(3.0, 8.0, 2.0);;
        points.add(p1);
        points.add(p2);
        points.add(p3);
        assertEquals(expected, Distance.matrix(points, new Manhattan()));
    }

}
