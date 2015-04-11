package ar.edu.desapp.grupoa.medicine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DrugTest {

	private Drug drug;

	@Before
	public void setUp(){
		
		drug = new Drug("Aspirina");
	}
	
	@Test
	public void drugDataNameTest(){
		String expected = "Aspirina";
		assertEquals(expected, drug.getName());
	}
	
}
