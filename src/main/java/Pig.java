package main.java;

public class Pig extends Animal{
    public Pig() {
        this.isBorn();
        this.setName("Pig");
        this.setProduct("Bacon");
        this.setQuality((int)Math.abs(Math.random()*100));
    }
}
