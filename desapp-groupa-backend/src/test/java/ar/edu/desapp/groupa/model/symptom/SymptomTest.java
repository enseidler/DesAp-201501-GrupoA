package ar.edu.desapp.groupa.model.symptom;

import static junit.framework.Assert.assertEquals;
import static ar.edu.desapp.groupa.model.builders.SymptomBuilder.*;

import org.junit.Before;
import org.junit.Test;

public class SymptomTest {
	
	private Symptom symptom;
	
	@Before
	public void setUp(){
		
		//symptom = new Symptom("Dolor de cabeza");
		
		symptom = aSymptom()
				.withDescription("Dolor de cabeza")
				.build();
	}
	
	@Test
	public void symptomDataDescriptionTest(){
		String expected = "Dolor de cabeza";
		assertEquals(expected, symptom.getDescription());
	}

}
