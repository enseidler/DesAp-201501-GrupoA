package ar.edu.desapp.groupa.model.user;

import static junit.framework.Assert.assertEquals;
import static ar.edu.desapp.groupa.model.builders.DoctorBuilder.*;

import org.junit.Before;
import org.junit.Test;


public class DoctorTest {
	
	private Doctor doctor;
	
	@Before
	public void setUp() {
		
		//doctor = new Doctor("Guillermo", "Sanchez", 87654321, "pass", 26319);
		
		doctor = aDoctor()
				.withName("Guillermo")
				.withSurname("Sanchez")
				.withDNI(87654321)
				.withPassword("pass")
				.withEnrollment(26319)
				.build();
	}
	
	@Test
	public void doctorDataEnrollmentTest() {
		Integer expected = 26319;
		assertEquals(expected, doctor.getEnrollment());
	}
	

}
