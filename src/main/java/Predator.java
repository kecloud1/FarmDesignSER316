package main.java;

import java.util.Random;

public class Predator {
    
    private static Random rand = new Random();
    private static int willAttack;
    
    public static boolean attack() {
        willAttack = rand.nextInt(10);
        if (willAttack >= 9) {
            return true;
        }
        return false;
    }

}
