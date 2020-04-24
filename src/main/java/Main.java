package main.java;

import java.util.ArrayList;

/**
 * This class serves as an entry point for the program. This class serves as a control for the 
 * program.
 * @author kelseycloud
 *
 */
public class Main {
    /**
     * Program entry. Comment made to satisfy checkstyle.
     * @param args - entry point
     */
    public static void main(String[] args) {
        int days = 0;
        int farmID = 2; 
        DayCycle dayCycle = new DayCycle(); 
        boolean isGameOver = false;
        ArrayList<Farm> farms = new ArrayList<Farm>();
        Farm firstFarm = new Farm(1);
        farms.add(firstFarm);
        
        System.out.println("Welcome to FarmSim! You are starting with one farm small farm.");

        
        //Game loop. Game starts here.
        while (!isGameOver) {
            dayCycle.switchToDay();
            
            //New Day info
            System.out.println("\nTodays is day " + (days + 1) +
                    "\n# of farms owned: " + farms.size() + "." +
                    "\nFunds in Bank: $" + Farm.getFunds() + "\n");
            
            //Get farm info for each farm and print to console
            for (Farm farm : farms) {
                ArrayList<Animal> temp = farm.getAnimals();
                int numCow = 0;
                int numChick = 0;
                int numPig = 0;
                for (Animal animal : temp) {
                    if (animal.getName().equals("Cow")) {
                        numCow++;
                    }
                    if (animal.getName().equals("Chicken")) {
                        numChick++;
                    }
                    if (animal.getName().equals("Pig")) {
                        numPig++;
                    }
                }
                System.out.println("\nFarm name: " + farm.getName() + "\nNuber of Cows: " + numCow + 
                        "\nNumber of Chickens: " + numChick + "\nNumber of Pigs: " + numPig + "\n");
            }
            
            //Sell product and gain passive income
            for (Farm farm : farms) {
                farm.collectPassiveIncome();
                //Sell animal product
                for (Animal animal : farm.getAnimals()) {
                    animal.harvestProduct();
                }                
            }
            
            //Upgrade farms if enough money achieved
            for (Farm farm : farms) {
                farm.upgradeFarm();
            }
            
            //Buy a new farm if all farms are upgraded and player has enough funds
            while (Farm.getFunds() >= 20000) {
                farms.add(new Farm (farmID));
                Farm.addFunds(-20000);
                farmID++;
            }
            
            
            
            
            
            
            
            
            
            
            
            
            //day over
            dayCycle.switchToNight();
            
            
            
            
            
            //end of loop. Check if game won.
            isGameOver = isGameOver(farms);
        }
        
        //Message when game is over.
        System.out.println("\nCongratulations! You've upgraded your farm "
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
