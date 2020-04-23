package main.java;

public class Chicken extends Animal {
    public Chicken() {
        this.isBorn();
        this.setName("Chicken");
        produces = new producesEggs(); //Strategy pattern
    }
}
