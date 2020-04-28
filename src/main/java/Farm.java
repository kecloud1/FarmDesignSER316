package main.java;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class represents a Farm object.
 * @author kelseycloud
 *
 */
public class Farm {
    AnimalFactory factory = new AnimalFactory();

    
    private int id;
    private static int funds = 500; //each farm starts with $500
    private int size;
    
    private ArrayList<Animal> animals;
    
    public static final int SMALL_FARM_MAX_ANIMALS = 30;
    public static final int MEDIUM_FARM_MAX_ANIMALS = 100;
    public static final int LARGE_FARM_MAX_ANIMALS = 200;
    
    public static final int SMALL_FARM = 1;
    public static final int MEDIUM_FARM = 2;
    public static final int LARGE_FARM = 3;

    /**
     * Method is a constructor for a new farm objects. Every farm starts with 2 of each animal.
     * @param id - number of farm.
     */
    public Farm(int id) {
        this.id = id;
        size = 1; //All new farms start as small farms.
        animals = new ArrayList<Animal>();
        
        //each farm starts with 2 of each animal.
        for (int x = 0; x < 2; x++) {
            animals.add(factory.makeAnimal("Cow"));
            animals.add(factory.makeAnimal("Chicken"));
            animals.add(factory.makeAnimal("Pig"));
        }
        
        System.out.println("A new farm (farm #" + id + ") has been created.");
    }
    
    /**
     * Method sets a new name for farm.
     * @param newId - new name for farm.
     */
    public void setName(int newId) {
        this.id = newId;
    }
    
    /**
     * Method retrieves name of farm object.
     * @return name of farm object.
     */
    public int getName() {
        return id;
    }
    
    /**
     * Method adds funds.
     * @param toBeAdded - int of funds accrued by farm during previous day/night cycle
     */
    public static void addFunds(int toBeAdded) {
        funds = funds + toBeAdded;
    }
    
    /**
     * Method returns funds available to farm object.
     * @return funds - current funds
     */
    public static int getFunds() {
        return funds;
    }
    
    /**
     * Method returns the size of the farm.
     * @return size - an int representing the size of the farm.
     */
    public int getSize() {
        return size;
    }
    

    /**
     * Method returns the number of animals on the farm.
     * @return animalCount - int number of animals on farm.
     */
    public int getAnimalCount() {
        int count = this.countCows() + this.countChickens() + this.countPigs();
        return count;
    }
    
    /**
     * Method adds a animal to the farm and increments the animal counter.
     * @param animal - Animal object to be added.
     */
    public void addAnimal(Animal animal) {
        if (size == 1 && animals.size() < 30) {
            animals.add(animal);
        }
        else if (size == 2 && animals.size() < 100) {
            animals.add(animal);
        }
        else if (size == 3 && animals.size() < 200) {
            animals.add(animal);
        }
        else {
            System.out.println("Cannot add animal. Max number of animals reached on this farm.");
        }
    }
    
    /**
     * Method removes an animal object from the farm, and decrements the animal counter.
     * @param animal - object to be removed
     * @return true if animal was removed, false if otherwise.
     */
    public boolean removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    

    /**
     * Method calculate passive income based on the number of animals on the farm.
     * @return incomeGenerated - passive income generated that day.
     */
    public int collectPassiveIncome() {
        int cowCount = 0;
        int chickenCount = 0;
        int pigCount = 0;
        
        int incomeGenerated = 0;
        
        for (Animal animal : animals) {
            if (animal.getName().contentEquals("Cow")) {
                cowCount++;
            }
            if (animal.getName().contentEquals("Chicken")) {
                chickenCount++;
            }
            if (animal.getName().contentEquals("Pig")) {
                pigCount++;
            }
        }
        incomeGenerated = 500 + (chickenCount * 2) + (cowCount * 1) + (pigCount * 2);
        
        System.out.println("Passive income generated today by farm #" + id + " :" + " $"
                + incomeGenerated);
        addFunds(incomeGenerated);
        return incomeGenerated;
    }
    
    /**
     * Method upgrades a farm if the farm has sufficient funds.
     */
    public void upgradeFarm() {
        if (funds > 1999 && this.getSize() == 1) {
            addFunds(-2000);
            this.size = MEDIUM_FARM;
            
            System.out.println("\nFarm number " + id + " has been upgraded to level " + size);
        }
        if (funds > 9999 && this.getSize() == 2) {
            addFunds(-10000);
            this.size = LARGE_FARM;
            
            System.out.println("\nFarm number " + id + " has been upgraded to level " + size);

        }
    }
    
    /**
     * Method counts total number of Cows on a farm.
     * @return num - number of cows on farm.
     */
    public int countCows() {
        int num = 0;
        for (Animal animal : animals) {
            if (animal.getName().equals("Cow")) {
                num++;
            }
            
        }
        return num;
    }
    
    /**
     * Method counts total number of Chickens on a farm.
     * @return num - number of chickens on farm.
     */
    public int countChickens() {
        int num = 0;
        for (Animal animal : animals) {
            if (animal.getName().equals("Chicken")) {
                num++;
            }
            
        }
        return num;
    }
    
    /**
     * Method counts total number of pigs on a farm.
     * @return num - number of pigs on farm.
     */
    public int countPigs() {
        int num = 0;
        for (Animal animal : animals) {
            if (animal.getName().equals("Pig")) {
                num++;
            }
            
        }
        return num;
    }
    
    /**
     * Method will populate additional animals if there are more than two. There is a 50% chance
     * that a new animal will be born for each type of animal.
     */
    public void doTheHankyPanky() {
        int numCows = countCows();
        int numChickens = countChickens();
        int numPigs = countPigs();
        
        if (numCows >= 2) {
            if (new Random().nextInt(10) >= 5) {
                animals.add(factory.makeAnimal("Cow"));
                System.out.println("A new baby cow was born!");

            }
        }
        
        if (numChickens >= 2) {
            if (new Random().nextInt(10) >= 5) {
                animals.add(factory.makeAnimal("Chicken"));
                System.out.println("A new baby chicken was born!");

            }
        }
        if (numPigs >= 2) {
            if (new Random().nextInt(10) >= 5) {
                animals.add(factory.makeAnimal("Pig"));
                System.out.println("A new baby pig was born!");
            }
        }
    }
}
