package ar.edu.desapp.grupoa.medicalRecord;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.user.Patient;

public class MedicalRecordTest {
	
	private MedicalRecord medicalRecord;
	private Patient patient1;
	private MedicalConsultation consultation1;
	
	
	@Before
	public void setUp(){
		
		patient1 = mock(Patient.class);
		consultation1 = mock(MedicalConsultation.class);
		medicalRecord = new MedicalRecord(patient1);
		
	}
	
	@Test
	public void medicalRecordDataPatient() {
		Patient expected = patient1;
		assertEquals(expected, medicalRecord.getPatient());
	}
	
	@Test 
	public void medicalRecordAddConsultation(){
		medicalRecord.addConsultation(consultation1);
		boolean expected = medicalRecord.getConsultations().contains(consultation1);
		assertTrue(expected);
	}

}
