package edu.umb.cs680.hw11;


import java.util.List;

public class Manhattan implements DistanceMetric{

    public double distance(List<Double> p1, List<Double> p2) throws Exception{
        if (p1.size() != p2.size()){
            throw new Exception("Size of p1 cannot be more than p2.");
        }else{
            double summation = 0.0;
            for(int i=0; i < p1.size(); i++) {
                summation += Math.abs( p1.get(i)-p2.get(i) );
            }
            return summation;
        }
    }

}
