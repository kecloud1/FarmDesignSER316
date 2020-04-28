package main.mainMethod;

import java.util.ArrayList;
import java.util.Random;

import main.java.Animal;
import main.java.DayCycle;
import main.java.Farm;
import main.java.Predator;

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
        Random rand = new Random();
        int farmID = 2; 
        DayCycle dayCycle = new DayCycle(); 
        boolean isGameOver = false;
        ArrayList<Farm> farms = new ArrayList<Farm>();
        Farm firstFarm = new Farm(1);
        farms.add(firstFarm);
        
        System.out.println("Welcome to FarmSim! You are starting with one farm small farm.");

        
        //Game loop. Game starts here.
        while (!isGameOver) {
            //New Day info
            System.out.println("\nTodays is day " + (dayCycle.getDays()) +
                    "\n# of farms owned: " + farms.size() + "." +
                    "\nFunds in Bank: $" + Farm.getFunds() + "\n");
            
            //Get animal info for each farm and print to console
            for (Farm farm : farms) {
                int numCow = farm.countCows();
                int numChick = farm.countChickens();
                int numPig = farm.countPigs();

                System.out.println("\nFarm #: " + farm.getName() + "\nNuber of Cows: " + numCow + 
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
            while (Farm.getFunds() >= 10000) {
                farms.add(new Farm (farmID));
                Farm.addFunds(-10000);
                farmID++;
                System.out.println("Congratulations! You bought a new farm!");
            }
            
            
            
            
            
            
            
            
            
            
            
            
            //day over
            dayCycle.switchToNight();
            
            //Character immune to disasters until day 10.
            if (dayCycle.getDays() > 10) {
                if (Predator.attack()) {
                    int priceOfAttack = rand.nextInt(1000);
                    System.out.println("Oh no! A predator attacked your animals! Your vet bill is: "
                            + priceOfAttack);
                    Farm.addFunds(-priceOfAttack);
                 }
                
                /*Check animals for sickness. Animals have a 5% chance of getting sick, and once they do,
                the animal dies.*/
                for (Farm farm : farms) {
                    ArrayList<Animal> list = farm.getAnimals();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isSick()) {
                            System.out.println("You lost an animal to sickness on farm #" + farm.getName() + ". "
                                    + "The animal you lost was a " + list.get(i).getName());
                            farm.getAnimals().remove(i);
                        }
    
                    }
                }
                
                //Check for animals who died of old age and remove them.
                for (Farm farm : farms) {
                    int numDied = 0;
                    ArrayList<Animal> list = farm.getAnimals();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getAge() > 14) {
                            farm.getAnimals().remove(list.get(i));
                            numDied++;
                        }
                    }
                    
                    System.out.println(numDied + " animals died last night due to old age.");
                }
            }
            
            //Animals have a chance to birth new animals every four days per assignment sheet.
            if (dayCycle.getDays()%4 == 0)
                for (Farm farm : farms) {
                    farm.doTheHankyPanky();
                }
            
            //end of loop. Check if game won.
            isGameOver = isGameOver(farms);
            
            dayCycle.switchToDay();
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
