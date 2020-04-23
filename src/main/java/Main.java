package main.java;

import java.util.ArrayList;

/**
 * This class serves as an entry point for the program. This class serves as a control for the 
 * program.
 * @author kelseycloud
 *
 */
public class Main {

    public static int days = 0;
    public static boolean isNight = true;
    public static boolean isDay = false;
    
    public static boolean isGameOver = false;
    
    
    public static ArrayList<Farm> farms = new ArrayList<Farm>();
    
    public static void main(String[] args) {
        while (!isGameOver) {
            isDay = true;
            isNight = false;
            
            //TODO: implement stuff
            
            isGameOver();
        }
        
        //Message when game is over.
        System.out.println("Congratulations! You've upgraded your farm entirely! Please start a "
                + "new simulation.");
    }
    
    //Method called at end of each day to determine when simulation ends.
    public static void isGameOver() {
        int numMaxFarms = 0;
        for (Farm farm : farms) {
            if (farm.getSize() == Farm.LARGE_FARM) {
                numMaxFarms++;
            }
        }
        
        if (numMaxFarms > 5) {
            isGameOver = true;
        }
    }
}
