package main.java;

import java.util.Random;

/**
 * This class serves as an abstract class, from which instance variables and methods are inherited.
 * Animal implements observer to track age.
 * @author kelseycloud
 *
 */
public abstract class Animal  implements Observer {
    private Random rand = new Random();
    private String name;
    private int daysOld;
    private int daysOldWhenHarvested;
    private boolean isProducingAge = false;
    private boolean hasProduct = false;
    public Produces produces;
    
    /**
     * Method returns name.
     * @return name - name of animal
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method sets name.
     * @param name - name of animal
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Method returns the animals age.
     * @return daysOld - how many days old the animal is
     */
    public int getAge() {
        return daysOld;
    }
    
    
    /**
     * Method is called when Animal object is created and begins counter for how old animal is.
     */
    protected void isBorn() {
        daysOld = 0;
    }
    
    /**
     * Method returns a boolean to indicate if the animal is of producing age.
     * @return isProducingAge - true if greater than 3 days old, false if otherwise.
     */
    public boolean isProducingAge() {
        if (daysOld >= 3) {
            isProducingAge = true;
        }
        return isProducingAge;
    }
    
    /**
     * Method returns the type of product that the animal produces.
     * @return produces - String of animal product
     */
    public String getProduct() {
        return produces.produces();
    }
    
    /**
     * Method sets the product that the animal produces.
     * @param bool - type of product animal produces
     */
    public void setHasProduct(boolean bool) {
        hasProduct = bool;
    }
    
    /**
     * When called, toString() returns a sentence indicating the type of animal.
     */
    public String toString() {
        String toString = "This animal is a " + name + ".";
        return toString;
    }
    
    /**
     * To be implemented in individual animal classes, because each product can 
     * be sold for a certain price. 
     */
    public void harvestProduct() {
        if (hasProduct()) {
            this.setHasProduct(false);
            this.setDaysOldOnLastHarvest(getAge());
            if (this.getProduct().equalsIgnoreCase("Milk")) {
                Farm.addFunds(5);
            }
            if (this.getProduct().equalsIgnoreCase("Egg")) {
                Farm.addFunds(2);
            }
            if (this.getProduct().equalsIgnoreCase("Bacon")) {
                Farm.addFunds(7);
            }
            return;
        }
    }
    
    /**
     * Method returns daysOldWhenHarvested.
     * @return daysOldWhenHarvested - all in the name
     */
    public int getDaysOldOnLastHarvest() {
        return daysOldWhenHarvested;
    }
    
    /**
     * Method returns daysOldWhenHarvested.
     * @param i - how old the animal was when last harvested.
     */
    public void setDaysOldOnLastHarvest(int i) {
        daysOldWhenHarvested = i;
    }
    
    /**
     * Method checks if animal has product for harvest.
     * @return
     */
    public boolean hasProduct() {
        return hasProduct;
    }
    
    /**
     * Method used to update observers of the DayCycle.
     */
    public void update(boolean day) { 
        if (day) {
            daysOld++;
            //Animal product reoccurs every two days, and only if the animal is 
            //at least 3 days old.
            if (daysOld >= 3 && daysOld - daysOldWhenHarvested >= 2) {
                hasProduct =  true;
            }
        }
    }
    
    /**
     * Animal has 5% chance of getting sick each night.
     * @return
     */
    public boolean isSick() {
        if (rand.nextInt(100) >= 95) {
            return true;
        }
        return false;
    }
}
