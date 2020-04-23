package main.java;

/**
 * Class represents a Pig object.
 * @author kelseycloud
 *
 */
public class Pig extends Animal {
    
    /**
     * Method constructs a Pig object.
     */
    public Pig() {
        this.isBorn();
        this.setName("Pig");
        produces = new ProducesBacon(); //Strategy pattern
    }
}
