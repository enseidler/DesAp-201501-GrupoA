package ar.edu.desapp.grupoa.medicalConsultationTest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.treatment.Treatment;
import ar.edu.desapp.grupoa.user.Doctor;

public class MedicalConsultationTest {
	
	private MedicalConsultation medicalConsultation;
	private Doctor doctor;
	private Symptom symptom;
	private Disease disease;
	private Treatment treatment; 
	
	@Before
	public void setUp(){
		
		doctor = mock(Doctor.class);
		symptom = mock(Symptom.class);
		disease = mock(Disease.class);
		treatment = mock(Treatment.class);
		medicalConsultation = new MedicalConsultation(doctor);
			
	}
	
	@Test
	public void medicalConsultationDataDoctorTest() {
		Doctor expected = doctor;
		assertEquals(expected, medicalConsultation.getDoctor());
	}
	
	@Test
	public void medicalConsultationaddSymptomTest(){
		medicalConsultation.addSymptom(symptom);
		boolean expected = medicalConsultation.getSymptoms().contains(symptom);
		assertTrue(expected);
	}
	
	@Test
	public void medicalConsultationdataTreatmentTest(){
		Treatment expected = null;
		assertEquals(expected, medicalConsultation.getTreatment());
	}
	
	@Test
	public void medicalConsultationdataDiseaseTest(){
		Disease expected = null;
		assertEquals(expected, medicalConsultation.getDignoseDiase());
	}
	
	
	@Test
	public void medicalConsultationaddTreatmentTest(){
		medicalConsultation.addTreatment(treatment);
		Treatment expected = treatment;
		assertEquals(expected, medicalConsultation.getTreatment());
	}
	
	@Test
	public void medicalConsultationaddiseaseTest(){
		medicalConsultation.addDignoseDiase(disease);
		Disease expected = disease;
		assertEquals(expected, medicalConsultation.getDignoseDiase());
	}
	
	
	

}
