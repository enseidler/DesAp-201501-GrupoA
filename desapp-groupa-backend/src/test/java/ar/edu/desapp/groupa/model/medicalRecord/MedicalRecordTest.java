package ar.edu.desapp.groupa.model.medicalRecord;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import static ar.edu.desapp.groupa.model.builders.MedicalRecordBuilder.*;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicine.Drug;


public class MedicalRecordTest {
	
	private MedicalRecord medicalRecord;
	private MedicalConsultation consultation1;
	private Drug drug1;
	private Drug drug2;
	private Disease disease1;
	private Disease disease2;
	
	
	@Before
	public void setUp(){
		
		consultation1 = mock(MedicalConsultation.class);
		
		medicalRecord = aMedicalRecord()
								.build();
		
		drug1 = mock(Drug.class);
		drug2 = mock(Drug.class);
		disease1 = mock(Disease.class);
		disease2 = mock(Disease.class);
	}
	
	@SuppressWarnings("deprecation")
	@Test 
	public void medicalRecordAddConsultationTest(){
		medicalRecord.addConsultation(consultation1);
		boolean expected = medicalRecord.getConsultations().contains(consultation1);
		assertTrue(expected);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addAllergie01Test() {
		medicalRecord.addAllergy(drug1);
		boolean expected = medicalRecord.getAllergies().contains(drug1);
		assertTrue(expected);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addAllergie02Test() {
		medicalRecord.addAllergy(drug1);
		boolean expected = medicalRecord.getAllergies().contains(drug2);
		assertFalse(expected);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addDisease01Test() {
		medicalRecord.addDisease(disease1);
		boolean expected = medicalRecord.getDiseases().contains(disease1);
		assertTrue(expected);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addDisease02Test() {
		medicalRecord.addDisease(disease1);
		boolean expected = medicalRecord.getDiseases().contains(disease2);
		assertFalse(expected);
	}

}
