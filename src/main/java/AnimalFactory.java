package main.java;

/**
 * Class implements the Factory design patter for the creation of Animal objects.
 * @author kelseycloud
 *
 */
public class AnimalFactory {
    
    /**
     * Method creates an Animal based on the input.
     * @param animalToCreate - Abbreviation that indicates which animal to be created.
     * @return animal object, depending on abbreviation passed to method.
     */
    public Animal makeAnimal(String animalToCreate) {
        if (animalToCreate.equalsIgnoreCase("Cow")) {
            return new MilkCow();
        }
        if (animalToCreate.equalsIgnoreCase("Chicken")) {
            return new Chicken();
        }
        if (animalToCreate.equalsIgnoreCase("Pig")) {
            return new Pig();
        }
        return null;
    }

}
