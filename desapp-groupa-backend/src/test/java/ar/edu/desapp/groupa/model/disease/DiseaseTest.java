package ar.edu.desapp.groupa.model.disease;

import static ar.edu.desapp.groupa.model.builders.DiseaseBuilder.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.desapp.groupa.model.symptom.Symptom;

public class DiseaseTest {
	
	private Disease migraña;
	private Symptom dolorDeCabeza;
	private Symptom sofocacion;
	
	@Before
	public void setUp() {
		dolorDeCabeza = mock(Symptom.class);
		sofocacion = mock(Symptom.class);
		migraña = aDisease("Migraña")
					.with(dolorDeCabeza)
					.build();
	}

	@Test
	public void diseaseDataNameTest() {
		String expected = "Migraña";
		assertEquals(expected, migraña.getName());
	}
	
	@Test
	public void symptomDataNameTest() {
		List<Symptom> expected = new ArrayList<Symptom>();
		expected.add(dolorDeCabeza);
		assertEquals(expected, migraña.getSymptoms());
	}
	
	@Test
	public void hasASymptom_HasTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(sofocacion);
		Boolean expected = migraña.hasASymptom(symptoms);
		assertTrue(expected);
	}

	@Test
	public void hasASymptom_NotHasTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(sofocacion);
		Boolean expected = migraña.hasASymptom(symptoms);
		assertFalse(expected);
	}
}
