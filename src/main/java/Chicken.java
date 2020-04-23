package main.java;

public class Chicken extends Animal {
    public Chicken() {
        this.isBorn();
        this.setName("Chicken");
        this.setProduct("Egg");
        this.setQuality((int)Math.abs(Math.random()*100));
    }
}
