package main.java;

/**
 * Class represetns a MilkCow object.
 * @author kelseycloud
 *
 */
public class MilkCow extends Animal {
    
    /**
     * Method is a constructor for a MilkCow object.
     */
    public MilkCow() {
        this.isBorn();
        this.setName("Milk Cow");
        produces = new ProducesMilk();
    }
    
    public void harvestProduct() {
    if (hasProduct()) {
        harvestProduct();
        Farm.addFunds(5);
    }
    return;
    }
}
