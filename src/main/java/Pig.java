package main.java;

/**
 * Class represents a Pig object.
 * @author kelseycloud
 *
 */
public class Pig extends Animal implements Observer{
    
    /**
     * Method constructs a Pig object.
     */
    public Pig() {
        this.isBorn();
        this.setName("Pig");
        produces = new ProducesBacon(); //Strategy pattern
    }
    
    public void harvestProduct() {
    if (hasProduct()) {
        this.setHasProduct(false);
        Farm.addFunds(7);
    }
    return;
    }
}
