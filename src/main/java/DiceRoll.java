package main.java;

public class DiceRoll {
    private static int roll;
    
    public int rollDice() {
        roll = 0;
        while (roll == 0) {
            roll = (int)Math.random()*10;
        }
        return roll;
    }

}
