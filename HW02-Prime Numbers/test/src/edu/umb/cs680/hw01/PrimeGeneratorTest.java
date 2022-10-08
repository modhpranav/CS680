package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void isinvalidinputrangetest(){
        long from = 100;
        long to = 10;
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> new PrimeGenerator(from, to),
                "Expected PrimeGenerator to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Wrong input values: from=100 to=10"), "Invalid range.");
    }

    @Test
    public void istruenumberofprimesgeneratedtest(){
        int expected = 25;
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        gen.generatePrimes();
        assertEquals(expected, gen.getPrimes().size(), "Total number of prime generated.");
    }

    @Test
    public void isfalsenumberofprimesgeneratedtest(){
        int expected = 30;
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        gen.generatePrimes();
        assertNotEquals(expected, gen.getPrimes().size(), "Total number of prime generated.");
    }

    @Test
    public void islistofprimesgeneratedtest(){
        Long[] expected = {2L,3L,5L,7L,11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        gen.generatePrimes();
        assertArrayEquals(expected, gen.getPrimes().toArray(), "List of prime numbers generated.");
    }


    @Test
    public void isprimetest(){
        PrimeGenerator gen = new PrimeGenerator(1, 3);
        boolean num_chck = gen.isPrime(7);
        assertEquals(true, num_chck);
    }

    @Test
    public void isoddtest(){
        PrimeGenerator gen = new PrimeGenerator(1, 3);
        boolean num_chck = gen.isEven(7);
        assertEquals(false, num_chck);
    }

    @Test
    public void iseventest(){
        PrimeGenerator gen = new PrimeGenerator(1, 3);
        boolean num_chck = gen.isEven(4);
        assertEquals(true, num_chck);
    }
}
