package main.java;

import java.util.Random;

/**
 * This class serves as an abstract class, from which instance variables and methods are inherited.
 * Animal implements observer to track age.
 * @author kelseycloud
 *
 */
public abstract class Animal  implements Observer{
    private String name;
    private int daysOld;
    private boolean isProducingAge = false;
    private boolean hasProduct = false;
    public Produces produces;
    private double quality = 0;
    private boolean isDay;
    
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
        this.isDay = true;
        this.setQuality();
    }
    
    /**
     * Method returns a boolean to indicate if the animal is of producing age.
     * @return isProducingAge - true if greater than 3 days old, false if otherwise.
     */
    public boolean isProducingAge() {
        if (daysOld > 3) {
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
     * @param product - type of product animal produces
     */
    public void setProduct(Produces product) {
        this.produces = product;
    }
    
    /**
     * When called, toString() returns a sentence indicating the type of animal.
     */
    public String toString() {
        String toString = "This animal is a " + name + ".";
        return toString;
    }
    
    /**
     * Method returns the quality of the animal.
     * @return quality - a random double between 0-10
     */
    public double getQuality() {
        return quality;
    }
    
    /**
     * Method can only be called when an animal is born and sets their quality as a double between 
     * 1-10.
     */
    private void setQuality() {
        while (quality < 1) {
            quality = new Random().nextInt(10);
        }
    }
    
    public abstract void harvestProduct();
    
    public boolean hasProduct() {
        return hasProduct;
    }
    
    public void update(boolean isDay) { 
        if (isDay) {
            if (daysOld > 3) {
                hasProduct =  true;
            }
        }
        this.isDay = isDay;
        daysOld++; 
    }
}
