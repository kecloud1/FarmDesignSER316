package main.java;

import java.util.ArrayList;

/**
 * This class serves as an entry point for the program. This class serves as a control for the 
 * program.
 * @author kelseycloud
 *
 */
public class Main {
    
    public static void main(String[] args) {
        int days = 0;
        boolean isNight = true;
        boolean isDay = false;
        
        boolean isGameOver = false;
        
        ArrayList<Farm> farms = new ArrayList<Farm>();

        while (!isGameOver) {
            isDay = true;
            isNight = false;
            
            //TODO: implement stuff
            
            isGameOver = isGameOver(farms);
        }
        
        //Message when game is over.
        System.out.println("Congratulations! You've upgraded your farm "
                + "entirely! Please start a new simulation.");
    }
    
    //Method called at end of each day to determine when simulation ends.
    protected static boolean isGameOver(ArrayList<Farm> farms) {
        int numMaxFarms = 0;
        for (Farm farm : farms) {
            if (farm.getSize() == Farm.LARGE_FARM) {
                numMaxFarms++;
            }
        }
        
        if (numMaxFarms > 5) {
            return true;
        }
        else {
            return false;
        }
    }
}
