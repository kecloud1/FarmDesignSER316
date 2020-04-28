package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.DayCycle;

public class DayCycleTest {

    @Test
    public void testDayCycle() {
        DayCycle cycle = new DayCycle();
        
        assertTrue(cycle.isDay());
        cycle.switchToNight();
        assertFalse(cycle.isDay());
        cycle.switchToDay();
        
        assertEquals(2, cycle.getDays());
    }
}
