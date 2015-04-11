package ar.edu.desapp.grupoa.symptom;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SymptomTest {
	
	private Symptom symptom;
	
	@Before
	public void setUp(){
		
		symptom = new Symptom("Dolor de cabeza");
	}
	
	@Test
	public void symptomDataDescriptionTest(){
		String expected = "Dolor de cabeza";
		assertEquals(expected, symptom.getDescription());
	}

}
