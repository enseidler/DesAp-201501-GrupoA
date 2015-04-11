package ar.edu.desapp.grupoa.medicalPractice;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

public class MedicalPracticeTest {
	
	private MedicalPractice medicalPractice;
	
	@Before
	public void setUp(){
		
		medicalPractice = new MedicalPractice("Quineseologia","7 sesiones");
	}
	
	@Test
	public void medicalPracticeNameTest(){
		String expected = "Quineseologia";
		assertEquals(expected, medicalPractice.getName());
	}
	
	@Test
	public void medicalPracticeDescriptionTest(){
		String expected = "7 sesiones";
		assertEquals(expected, medicalPractice.getDescription());
	}

}
