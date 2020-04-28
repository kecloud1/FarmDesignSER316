package test.java;

import main.java.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This test class serves to test the various animal classes (Pig, Chicken, and 
 * MilkCow), AnimalFactory.java, and Animal.java
 * @author KelseyCloud
 *
 */
public class AnimalTest {    
    Farm farm = new Farm(1);
    AnimalFactory factory = new AnimalFactory();
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    /**
     * Test checks that animal factory makes animals with the correct class, and
     * that animal Factory delegates the creation of animals based on what
     * string is passed. 
     */
    public void testAnimalFactory() {
        Animal cow = factory.makeAnimal("Cow");
        Animal chicken = factory.makeAnimal("Chicken");
        Animal pig = factory.makeAnimal("pig");
        
        final MilkCow cowNotMadeInFactory = new MilkCow();
        final Chicken chickenNotMadeInFactory = new Chicken();
        final Pig pigNotMadeInFactory = new Pig();
        
        assertEquals("Cow", cow.getName());
        assertEquals("Chicken", chicken.getName());
        assertEquals("Pig", pig.getName());
        assertNull(factory.makeAnimal("invalidEntry"));
        
        boolean bool = false;
        if (cow.getClass().equals(cowNotMadeInFactory.getClass())) {
            bool = true;
        }
        assertTrue(bool);
        bool = false;
        
        if (chicken.getClass().equals(chickenNotMadeInFactory.getClass())) {
            bool = true;
        }
        assertTrue(bool);
        bool = false;
        
        if (pig.getClass().equals(pigNotMadeInFactory.getClass())) {
            bool = true;
        }
        assertTrue(bool);
        
    }
    
    @Test
    public void testMilkCowClass() {
        DayCycle day = new DayCycle();
        MilkCow testCow = new MilkCow();
        farm.addAnimal(testCow);
        boolean bool = false;
        
        day.switchToNight();//end of day1
        
        day.switchToDay();
        day.switchToNight();//end of day2
        
        day.switchToDay();
        day.switchToNight();//end of day3, animal should not have product
        assertFalse(testCow.hasProduct());
        
        day.switchToDay(); //day4, animal should have product
        assertTrue(testCow.hasProduct());
        testCow.harvestProduct();
        assertFalse(testCow.hasProduct());//animal has been harvested
        
        day.switchToNight();
        day.switchToDay(); //day5, animal should not have product
        assertFalse(testCow.hasProduct());
        
        day.switchToNight();
        day.switchToDay();//day6, animal should have product
        
        assertTrue(testCow.hasProduct());
    }
    
    @Test
    public void testChickenClass() {
        DayCycle day = new DayCycle();
        Chicken testChick = new Chicken();
        farm.addAnimal(testChick);
        boolean bool = false;
        
        day.switchToNight();//end of day1
        
        day.switchToDay();
        day.switchToNight();//end of day2
        
        day.switchToDay();
        day.switchToNight();//end of day3, animal should not have product
        assertFalse(testChick.hasProduct());
        
        day.switchToDay(); //day4, animal should have product
        assertTrue(testChick.hasProduct());
        testChick.harvestProduct();
        assertFalse(testChick.hasProduct());//animal has been harvested
        
        day.switchToNight();
        day.switchToDay(); //day5, animal should not have product
        assertFalse(testChick.hasProduct());
        
        day.switchToNight();
        day.switchToDay();//day6, animal should have product
        
        assertTrue(testChick.hasProduct());
        
    }
    
    @Test
    public void testPigClass() {
        DayCycle day = new DayCycle();
        Pig testPig = new Pig();
        farm.addAnimal(testPig);
        boolean bool = false;
        
        day.switchToNight();//end of day1
        
        day.switchToDay();
        day.switchToNight();//end of day2
        
        day.switchToDay();
        day.switchToNight();//end of day3, animal should not have product
        assertFalse(testPig.hasProduct());
        
        day.switchToDay(); //day4, animal should have product
        assertTrue(testPig.hasProduct());
        testPig.harvestProduct();
        assertFalse(testPig.hasProduct());//animal has been harvested
        
        day.switchToNight();
        day.switchToDay(); //day5, animal should not have product
        assertFalse(testPig.hasProduct());
        
        day.switchToNight();
        day.switchToDay();//day6, animal should have product
        
        assertTrue(testPig.hasProduct());
        
    }
    
    @Test
    public void testAge() {
        DayCycle day = new DayCycle();
        final Animal animal = factory.makeAnimal("Cow");
        
        day.switchToNight();
        day.switchToDay();
        day.switchToNight();
        day.switchToDay();
        day.switchToNight();
        
        assertEquals(2, animal.getAge());
        assertFalse(animal.isProducingAge());
        
        day.switchToDay();
        day.switchToNight();
        
        assertTrue(animal.isProducingAge());
        assertTrue(animal.hasProduct());
        
        animal.harvestProduct();
        assertEquals(3, animal.getDaysOldOnLastHarvest());
        
    }
    
    /**
     * Behavior is unpredictable by design, but output is printed to observe 
     * pattern. Should attack approx 10% of the time. Test asserts this with 
     * plus or minus 8%.
     */
    @Test
    public void testPredator() {
        int numOfAttacks = 0;
        for (int i = 0; i < 100; i++) {
            if (new Predator().attack()) {
                numOfAttacks++;
            }
        }
        int percentAttack = 100 / numOfAttacks;
        System.out.println("Percent chance of attack: " + (percentAttack));
        assertEquals(10, percentAttack, 8);
        
    }

}

