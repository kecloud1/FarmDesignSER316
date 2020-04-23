package main.java;

public class Pig extends Animal{
    public Pig() {
        this.isBorn();
        this.setName("Pig");
        produces = new producesBacon(); //Strategy pattern
    }
}
