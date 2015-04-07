package ar.edu.desapp.grupoa.user;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicine.Drug;

public class PatientTest {

	private Patient patient1;
	private Drug drug1;
	private Drug drug2;
	private Disease disease1;
	private Disease disease2;
	
	@Before
	public void setUp() {
		patient1 = new Patient("Ezequiel","Seidler",12345678,"pass", 75, 1.81);
		
		drug1 = mock(Drug.class);
		drug2 = mock(Drug.class);
		disease1 = mock(Disease.class);
		disease2 = mock(Disease.class);
	}
	
	@Test
	public void userDataNameTest() {
		String expected = "Ezequiel";
		assertEquals(expected, patient1.getName());
	}
	
	@Test
	public void userDataSurnameTest() {
		String expected = "Seidler";
		assertEquals(expected, patient1.getSurname());
	}
	
	@Test
	public void userDataDNITest() {
		Integer expected = 12345678;
		assertEquals(expected, patient1.getDni());
	}
	
	@Test
	public void userDataPasswordTest() {
		String expected = "pass";
		assertEquals(expected, patient1.getPassword());
	}
	
	@Test
	public void patientDataWightTest() {
		double expected = 75;
		assertEquals(expected, patient1.getWight());
	}
	
	@Test
	public void patientDataHeightTest() {
		double expected = 1.81;
		assertEquals(expected, patient1.getHeight());
	}

	@Test
	public void addAllergie01Test() {
		patient1.addAllergie(drug1);
		boolean expected = patient1.getAllergies().contains(drug1);
		assertTrue(expected);
	}
	
	@Test
	public void addAllergie02Test() {
		patient1.addAllergie(drug1);
		boolean expected = patient1.getAllergies().contains(drug2);
		assertFalse(expected);
	}
	
	@Test
	public void addDisease01Test() {
		patient1.addDisease(disease1);
		boolean expected = patient1.getDiseases().contains(disease1);
		assertTrue(expected);
	}

	@Test
	public void addDisease02Test() {
		patient1.addDisease(disease1);
		boolean expected = patient1.getDiseases().contains(disease2);
		assertFalse(expected);
	}
	
	
}
