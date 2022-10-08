package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonClassTest {

    @Test
    public void CheckGetInstanceOutput(){
        SingletonClass singletonclass = SingletonClass.getInstance();
        assertNotNull(singletonclass);
    }

    @Test
    public void CheckHashCode(){
        SingletonClass first_instance = SingletonClass.getInstance();
        SingletonClass second_instance = SingletonClass.getInstance();
        assertEquals(first_instance.hashCode(), second_instance.hashCode());
    }

}
