package ar.edu.desapp.groupa.model.medicalConsultation;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import static ar.edu.desapp.groupa.model.builders.MedicalConsultationBuilder.*;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.user.Doctor;

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
		//medicalConsultation = new MedicalConsultation(doctor);
		medicalConsultation = aMedicalRecord(doctor).build();
		
	}
	
	@Test
	public void medicalConsultationDataDoctorTest() {
		Doctor expected = doctor;
		assertEquals(expected, medicalConsultation.getDoctor());
	}
	
	@Test
	public void medicalConsultationdataTreatmentTest(){
		Treatment expected = null;
		assertEquals(expected, medicalConsultation.getTreatment());
	}
	
	@Test
	public void medicalConsultationdataDiseaseTest(){
		Disease expected = null;
		assertEquals(expected, medicalConsultation.getDiagnoseDisease());
	}
	
	
	@Test
	public void medicalConsultationaddTreatmentTest(){
		medicalConsultation.addTreatment(treatment);
		Treatment expected = treatment;
		assertEquals(expected, medicalConsultation.getTreatment());
	}
	
	@Test
	public void medicalConsultationaddiseaseTest(){
		medicalConsultation.addDiagnoseDisease(disease);
		Disease expected = disease;
		assertEquals(expected, medicalConsultation.getDiagnoseDisease());
	}
	
	
	

}
