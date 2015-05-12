package ar.edu.desapp.groupa.model.medicalPractice;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

import static ar.edu.desapp.groupa.model.builders.MedicalPracticeBuilder.*;

public class MedicalPracticeTest {
	
	private MedicalPractice medicalPractice;
	
	@Before
	public void setUp(){
		
		//medicalPractice = new MedicalPractice("Quineseologia","7 sesiones");
		medicalPractice = aMedicalPractice()
				.withName("Quineseologia")
				.withDescription("7 sesiones")
				.build();
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
