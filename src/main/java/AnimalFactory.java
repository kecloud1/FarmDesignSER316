package main.java;

//Factory design pattern
public class AnimalFactory {
    
    public Animal makeAnimal(String animalToCreate) {
        if (animalToCreate.equals("MC")) {
            return new MilkCow();
        }
        if (animalToCreate.equals("CH")) {
            return new Chicken();
        }
        if (animalToCreate.equals("P")) {
            return new Pig();
        }
        return null;
    }

}
