package edu.umb.cs680.hw17;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DJIAQuoteObservableTest {
    @Test
    public void notifyStockQuoteObservers(){

        T3DObserver t3dobs = new T3DObserver();
        LineChartObserver lineobs = new LineChartObserver();

        Observer updttableobs = (Observable sender,Object event)->{
            System.out.println("Name: " + ((Double) event));
        };

        DJIAQuoteObservable djia = new DJIAQuoteObservable();

        djia.addObserver(updttableobs);
        djia.addObserver(t3dobs);
        djia.addObserver(lineobs);

        djia.changeQuote(568.6);




        djia.changeQuote(1456.6);





        djia.removeObserver(updttableobs);
        djia.removeObserver(lineobs);
        djia.removeObserver(t3dobs);



    }
}