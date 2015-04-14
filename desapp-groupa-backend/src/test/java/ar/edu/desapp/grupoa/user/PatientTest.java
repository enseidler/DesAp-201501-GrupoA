package ar.edu.desapp.grupoa.user;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static ar.edu.desapp.grupoa.builders.PatientBuilder.*;


public class PatientTest {

	private Patient patient1;

	
	@Before
	public void setUp() {
		
		patient1 = aPatient()
					.withName("Ezequiel")
					.withSurname("Seidler")
					.withDNI(12345678)
					.withPassword("pass")
					.withWight(75)
					.withHeight(1.81)
					.build();		
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

}
