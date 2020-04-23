package main.java;

import java.util.Random;

public class DiceRoll {
    
    /**
     * Method returns a random int between 1 and 10.
     * @return roll - randome into between 1 and 10.
     */
    public int rollDice() {
        int roll = 0;
        while (roll == 0) {
            roll = (new Random().nextInt(10));
        }
        return roll;
    }

}
