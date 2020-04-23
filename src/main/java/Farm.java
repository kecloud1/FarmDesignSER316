package main.java;

import java.util.ArrayList;

public class Farm {
    
    private String name;
    private int funds;
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

    //Constructor
    public Farm(String newName) {
        name = newName;
        funds = 200; //All farms start with $200
        size = 1; //All new farms start as small farms.
        farmers = new ArrayList<Farmer>();
        animals = new ArrayList<Animal>();
        
        System.out.println("A new farm named " + newName + " has been created.");
    }
    
    //Class methods
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return name;
    }
    /**
     * Method intended to be used only in newDay()
     * @param toBeAdded - int of funds accrued by farm during previous day/night cycle
     */
    protected void addFunds(int toBeAdded) {
        this.funds = funds + toBeAdded;
    }
    
    public int getFunds() {
        return funds;
    }
    
    public int getSize() {
        return size;
    }
    
    //Add and remove farmers and update counter
    private void incrementFarmerCount() {
        farmerCount++;
    }
    
    private void decrementFarmerCount() {
        farmerCount--;
    }
    
    public int getFarmerCount() {
        return farmerCount;
    }
    
    public void addFarmer(Farmer farmer) {
        if (farmerCount < 6) {
            farmers.add(farmer);
            incrementFarmerCount();
        }
        else {
            System.out.println("Cannon add farmer. Max number of farmers reached on this farm.");
        }
    }
    
    public boolean removeFarmer(Farmer farmer) {
        if (farmers.remove(farmer)) {
            decrementFarmerCount();
            return true;
        }
        return false;
    }
    //Add and remove animals and update counter
    private void incrementAnimalCount() {
        animalCount++;
    }
    
    private void decrementAnimalCount() {
        animalCount--;
    }
    
    public int getAnimalCount() {
        return animalCount;
    }
    
    public void addAnimal(Animal animal) {
        if (animalCount < 6) {
            animals.add(animal);
            incrementAnimalCount();
        }
        else {
            System.out.println("Cannon add animal. Max number of animals reached on this farm.");
        }
    }
    
    public boolean removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            decrementAnimalCount();
            return true;
        }
        return false;
    }
    
    public void newDay() {
        addFunds(this.getPassiveIncome());
    }

    private int getPassiveIncome() {
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
        incomeGenerated = (chickenCount * 2) + (cowCount * 1) + (pigCount *2);
        
        System.out.println("Passive income generated today: $" + incomeGenerated );
        return incomeGenerated;
    }
}
