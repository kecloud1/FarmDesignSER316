package main.java;

public class MilkCow extends Animal {
    
    public MilkCow() {
        this.isBorn();
        this.setName("Milk Cow");
        produces = new producesMilk();
    }
}
