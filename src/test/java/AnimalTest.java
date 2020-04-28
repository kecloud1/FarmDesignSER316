package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Animal;
import main.java.AnimalFactory;

public class AnimalTest {
	AnimalFactory factory = new AnimalFactory();
	Animal cow = factory.makeAnimal("Cow");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Cow", cow.getName());
	}

}

