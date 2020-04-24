package main.java;

/**
 * Class represetns a MilkCow object.
 * @author kelseycloud
 *
 */
public class MilkCow extends Animal implements Observer{
    
    /**
     * Method is a constructor for a MilkCow object.
     */
    public MilkCow() {
        this.isBorn();
        this.setName("Cow");
        produces = new ProducesMilk();
    }
    
    public void harvestProduct() {
    if (hasProduct()) {
        this.setHasProduct(false);
        Farm.addFunds(5);
    }
    return;
    }
}
