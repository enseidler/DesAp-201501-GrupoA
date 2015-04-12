package ar.edu.desapp.grupoa.disease;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.desapp.grupoa.symptom.Symptom;

public class DiseaseTest {
	
	private Disease migraña;
	private Symptom dolorDeCabeza;
	List<Symptom> symptoms = new ArrayList<Symptom>();
	
	@Before
	public void setUp(){
		dolorDeCabeza = new Symptom("Dolor De Cabeza");
		
		symptoms.add(dolorDeCabeza);
		migraña = new Disease("Migraña", symptoms);
	}

	@Test
	public void diseaseDataNameTest(){
		String expected = "Migraña";
		assertEquals(expected, migraña.getName());
	}
	
	@Test
	public void symptomDataNameTest(){
		List<Symptom> expected = symptoms;
		assertEquals(expected, migraña.getSymptoms());
	}
}
