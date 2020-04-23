package main.java;

/**
 * Class represents a Chicken object.
 * @author kelseycloud
 */
public class Chicken extends Animal {
    
    /**
     * Method is a constructor for a chicken object.
     */
    public Chicken() {
        this.isBorn();
        this.setName("Chicken");
        produces = new ProducesEggs(); //Strategy pattern
    }
}
