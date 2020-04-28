package main.java;

import java.util.Random;

/**
 * Class represents an instance of a predator.
 * @author KelseyCloud
 *
 */
public class Predator {
    
    private static Random rand = new Random();
    private static int willAttack;
    
    /**
     * Method returns a boolean based on if the predator attacked. There is a 10% chance of attack.
     * @return
     */
    public static boolean attack() {
        willAttack = rand.nextInt(10);
        if (willAttack >= 9) {
            return true;
        }
        return false;
    }

}
