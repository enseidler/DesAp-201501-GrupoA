package ar.edu.desapp.grupoa.user;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class DoctorTest {
	
	private Doctor doctor;
	
	@Before
	public void setUp() {
		
		doctor = new Doctor("Guillermo", "Sanchez", 87654321, "pass", 26319);		
	}
	
	@Test
	public void doctorDataEnrollmentTest() {
		Integer expected = 26319;
		assertEquals(expected, doctor.getEnrollment());
	}
	

}
