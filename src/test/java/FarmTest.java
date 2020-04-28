package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.java.*;

import org.junit.Test;

public class FarmTest {
    Farm farm = new Farm(1);
    AnimalFactory factory = new AnimalFactory();
    
    @Test
    public void testFarm() {
        assertEquals(1, farm.getName());
        farm.setName(2);
        assertEquals(2, farm.getName());
    }

    @Test
    public void testAddandRemoveAnimals() {
        assertEquals(6, farm.getAnimalCount()); //each farm starts with six
        
        Animal cow = factory.makeAnimal("Cow");
        farm.addAnimal(cow);
        farm.addAnimal(factory.makeAnimal("Chicken"));
        farm.addAnimal(factory.makeAnimal("Pig"));
        
        assertEquals(9, farm.getAnimalCount());
        
        farm.removeAnimal(cow);
        assertEquals(8, farm.getAnimalCount());


    }
    
    @Test
    public void testFunds() {
        int funds = farm.getFunds();
        farm.addFunds(200);
        
        assertEquals((funds + 200), farm.getFunds());
    }
    
    @Test
    public void testSizeAndUpgrade() {
        assertEquals(1, farm.getSize());
        farm.addFunds(2000);
        farm.upgradeFarm();
        assertEquals(2, farm.getSize());
        
        farm.addAnimal(factory.makeAnimal("Cow"));
        farm.addFunds(10000);
        farm.upgradeFarm();
        assertEquals(3, farm.getSize());
        
        farm.addAnimal(factory.makeAnimal("Chicken"));
        assertEquals(8, farm.getAnimalCount());
    }

    @Test
    public void testCollectPassiveIncome() {
        farm.collectPassiveIncome();
        System.out.print(farm.getFunds());
        assertEquals(510, farm.collectPassiveIncome());
        
    }
    
    /**
     * Behavior is unpredictable by design, but output is printed to observe 
     * pattern. Each type of animal has a 50% chance of bearing one offspring
     * per method call
     */
    @Test
    public void testDoTheHanky() {
        farm.doTheHankyPanky();
        System.out.println("-----------");
        
        farm.doTheHankyPanky();
        System.out.println("-----------");
        
        farm.doTheHankyPanky();
        System.out.println("-----------");
        
        farm.doTheHankyPanky();
        System.out.println("-----------");
        
        farm.doTheHankyPanky();
        System.out.println("-----------");
    }
}
