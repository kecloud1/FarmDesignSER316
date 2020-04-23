package main.java;

public class MilkCow extends Animal {
    
    public MilkCow() {
        this.isBorn();
        this.setName("Milk Cow");
        this.setProduct("Milk");
        this.setQuality((int)Math.abs(Math.random()*100));
    }
}
