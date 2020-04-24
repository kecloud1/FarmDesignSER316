package main.java;

import java.util.ArrayList;

/**
 * Class represents a Farm object.
 * @author kelseycloud
 *
 */
public class Farm {
    
    private int id;
    private static int funds = 2000; //each player starts with $500
    private int size;

    private int farmerCount = 0;
    private int animalCount = 0;
    
    private ArrayList<Farmer> farmers;
    private ArrayList<Animal> animals;
    
    public static final int SMALL_FARM_MAX_ANIMALS = 30;
    public static final int SMALL_FARM_MAX_FARMERS = 3;
    
    public static final int MEDIUM_FARM_MAX_ANIMALS = 100;
    public static final int MEDIUM_FARM_MAX_FARMERS = 10;
    
    public static final int LARGE_FARM_MAX_ANIMALS = 200;
    public static final int LARGE_FARM_MAX_FARMERS = 20;
    
    public static final int SMALL_FARM = 1;
    public static final int MEDIUM_FARM = 2;
    public static final int LARGE_FARM = 3;

    /**
     * Method is a constructor for a new farm objects.
     * @param newName - name of farm.
     */
    public Farm(int ID) {
        id = ID;
        size = 1; //All new farms start as small farms.
        farmers = new ArrayList<Farmer>();
        animals = new ArrayList<Animal>();
        
        System.out.println("A new farm named " + ID + " has been created.");
    }
    
    /**
     * Method sets a new name for farm.
     * @param newName - new name for farm.
     */
    public void setName(int newID) {
        this.id = newID;
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
     * Method intended only to be used when addFarmer() is called.
     */
    private void incrementFarmerCount() {
        farmerCount++;
    }
    
    /**
     * Method intended only to be used when removeFarmer() is called.
     */
    private void decrementFarmerCount() {
        farmerCount--;
    }
    
    /**
     * Method returns the number of farmers on the farm.
     * @return farmerCount - int number of farmers on farm.
     */
    public int getFarmerCount() {
        return farmerCount;
    }
    
    /**
     * Method adds a farmer to the farm and increments the farmer counter.
     * @param farmer - Farmer object to be added.
     */
    public void addFarmer(Farmer farmer) {
        //Check if farm has reached max num of farmers
        if (farmerCount < 6) {
            farmers.add(farmer);
            incrementFarmerCount();
        }
        else {
            System.out.println("Cannon add farmer. Max number of farmers reached on this farm.");
        }
    }
    
    /**
     * Method removes a farmer from the farm, and decrements the farmer counter.
     * @param farmer - object to be removed
     * @return true if farmer was removed, false if otherwise.
     */
    public boolean removeFarmer(Farmer farmer) {
        if (farmers.remove(farmer)) {
            decrementFarmerCount();
            return true;
        }
        return false;
    }
    
    /**
     * Method intended only to be used when addAnimal() is called.
     */
    private void incrementAnimalCount() {
        animalCount++;
    }
    
    /**
     * Method intended only to be used when removeAnimal() is called.
     */
    private void decrementAnimalCount() {
        animalCount--;
    }
    
    /**
     * Method returns the number of animals on the farm.
     * @return animalCount - int number of animals on farm.
     */
    public int getAnimalCount() {
        return animalCount;
    }
    
    /**
     * Method adds a animal to the farm and increments the animal counter.
     * @param animal - Animal object to be added.
     */
    public void addAnimal(Animal animal) {
        if (animalCount < 6) {
            animals.add(animal);
            incrementAnimalCount();
        } 
        else {
            System.out.println("Cannon add animal. Max number of animals reached on this farm.");
        }
    }
    
    /**
     * Method removes an animal object from the farm, and decrements the animal counter.
     * @param animal - object to be removed
     * @return true if animal was removed, false if otherwise.
     */
    public boolean removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            decrementAnimalCount();
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
    public void collectPassiveIncome() {
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
        incomeGenerated = (chickenCount * 2) + (cowCount * 1) + (pigCount * 2);
        
        System.out.println("Passive income generated today: $" + incomeGenerated);
        addFunds(incomeGenerated);
    }
    
    public void upgradeFarm() {
        if (funds > 1999 && this.getSize() == 1) {
            funds = funds - 2000;
            this.size = MEDIUM_FARM;
            
            System.out.println("\nFarm number " + id + " has been upgraded to level " + size);
        }
        if (funds > 9999 && this.getSize() == 2) {
            funds = funds - 10000;
            this.size = LARGE_FARM;
            
            System.out.println("\nFarm number " + id + " has been upgraded to level " + size);

        }
    }
}

















