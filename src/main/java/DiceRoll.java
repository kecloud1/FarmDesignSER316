package main.java;

import java.util.Random;

public class DiceRoll {
    
    public int rollDice() {
        int roll = 0;
        while (roll == 0) {
            roll = (new Random().nextInt(10));
        }
        return roll;
    }

}
