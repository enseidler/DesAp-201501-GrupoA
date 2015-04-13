package ar.edu.desapp.grupoa.system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exeptions.RecordExistException;
import ar.edu.desapp.grupoa.medicalRecord.MedicalRecord;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.system.Hospital;
import ar.edu.desapp.grupoa.user.Doctor;
import ar.edu.desapp.grupoa.user.Patient;
import static ar.edu.desapp.grupoa.builders.DiseaseBuilder.*;

public class HospitalTest {
	
	private Hospital hospital1;
	private Hospital hospital2;
	private MedicalRecord medRecord1;
	private MedicalRecord medRecord2;
	private Symptom dolorDeCabeza;
	private Symptom dolorDeGarganta;
	private Disease migraña;
	private Disease resfrio;
	private Disease conjuntivitis;
	private Patient patient1;
	private Patient patient2;
	private Doctor doctor1;
	
	
	@Before
	public void setUp() throws RuntimeException {
		
		// -Diseases- //
		dolorDeCabeza = mock(Symptom.class);
		dolorDeGarganta = mock(Symptom.class);
		migraña = aDisease("Migraña")
					.with(dolorDeCabeza)
					.build();
		resfrio = aDisease("Resfrio")
					.with(dolorDeCabeza)
					.with(dolorDeGarganta)
					.build();
		conjuntivitis = aDisease("Conjuntivitis").build();
		
		// -People- //
		patient1 = mock(Patient.class);
		patient2 = mock(Patient.class);
		doctor1 = mock(Doctor.class);

		// -Records- //
		medRecord1 = mock(MedicalRecord.class);
		when(medRecord1.getPatient()).thenReturn(patient1);
		when(medRecord1.sufferedDisease(resfrio)).thenReturn(true);
		when(medRecord1.sufferedDisease(migraña)).thenReturn(true);
		when(medRecord1.sufferedDisease(conjuntivitis)).thenReturn(false);
		List<Disease> rec1Suffered = new ArrayList<Disease>();
		rec1Suffered.add(resfrio);
		rec1Suffered.add(migraña);
		when(medRecord1.getDiseases()).thenReturn(rec1Suffered);
		medRecord2 = mock(MedicalRecord.class);
		when(medRecord2.getPatient()).thenReturn(patient2);
		when(medRecord2.sufferedDisease(resfrio)).thenReturn(false);
		when(medRecord2.sufferedDisease(migraña)).thenReturn(true);
		when(medRecord2.sufferedDisease(conjuntivitis)).thenReturn(true);
		List<Disease> rec2Suffered = new ArrayList<Disease>();
		rec2Suffered.add(migraña);
		rec2Suffered.add(conjuntivitis);
		when(medRecord2.getDiseases()).thenReturn(rec2Suffered);
		

		
		// -System- //
		hospital1 = new Hospital();
		hospital1.addDisease(resfrio);
		hospital2 = new Hospital();
		hospital2.addDisease(resfrio);
		hospital2.addDisease(migraña);
		hospital2.addDisease(conjuntivitis);
		hospital2.addMedicalRecord(medRecord1);
		hospital2.addMedicalRecord(medRecord2);
	
	}

	
	/*
	@Test
	public void compareSymptomsResfrioTest() throws NotFoundDiseaseException {
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		Disease actual = hospital1.compareSymptoms(symptoms);
		Disease expected = resfrio;
		assertEquals(expected, actual);
	}

	@Test(expected = NotFoundDiseaseException.class)
	public void compareSymptomsExeptionTest() throws NotFoundDiseaseException {
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeEstomago);
		Disease expected = hospital1.compareSymptoms(symptoms);
	}
	*/
	
	///////
	
	
	@Test 
	public void existRecordForPatientTest() throws RecordExistException {
		hospital1.addMedicalRecord(medRecord1);
		hospital1.addMedicalRecord(medRecord2);
		Boolean condition = hospital1.existRecordFor(patient1);
		assertTrue(condition);
	}

	@Test
	public void notExistRecordForPatientTest() throws RecordExistException {
		hospital1.addMedicalRecord(medRecord2);
		Boolean condition = hospital1.existRecordFor(patient1);
		assertFalse(condition);
	}

	@Test
	public void addPatientTest() {
		hospital1.addPatient(patient1);
		Boolean condition = hospital1.getPatients().contains(patient1);
		assertTrue(condition);
	}

	@Test
	public void notAddPatientTest() {
		hospital1.addPatient(patient1);
		Boolean condition = hospital1.getPatients().contains(patient2);
		assertFalse(condition);
	}

	@Test
	public void addDoctorTest() {
		hospital1.addDoctor(doctor1);
		Boolean condition = hospital1.getDoctors().contains(doctor1);
		assertTrue(condition);
	}

	@Test
	public void notAddDoctorTest() {
		Boolean condition = hospital1.getDoctors().contains(doctor1);
		assertFalse(condition);
	}

	@Test
	public void addMedicalRecordUnexistentTest() throws RecordExistException {
		hospital1.addMedicalRecord(medRecord2);
		Boolean condition = hospital1.getMedicalRecords().contains(medRecord2);
		assertTrue(condition);
	}

	@Test(expected = RecordExistException.class)
	public void addMedicalRecordExistentTest() throws RecordExistException {
		hospital1.addMedicalRecord(medRecord2);
		hospital1.addMedicalRecord(medRecord1);
		hospital1.addMedicalRecord(medRecord2);
	}
	
	@Test
	public void possibleDiseasesForSymptomsListTest() {		
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		List<Disease> expected = new ArrayList<Disease>();
		expected.add(resfrio);
		expected.add(migraña);
		List<Disease> actual = hospital2.possibleDiseases(symptoms);
		assertEquals(expected,actual);
	}
	
	@Test
	public void recordsFromPatientsWhoSufferedResfrioTest() throws RecordExistException {
		List<MedicalRecord> expected = new ArrayList<MedicalRecord>();
		expected.add(medRecord1);
		List<MedicalRecord> actual = hospital2.recordsFromPatientsWhoSuffered(resfrio);
		assertEquals(expected, actual);
	}

	@Test
	public void recordsFromPatientsWhoSufferedMigrañaTest() throws RecordExistException {
		List<MedicalRecord> expected = new ArrayList<MedicalRecord>();
		expected.add(medRecord1);
		expected.add(medRecord2);
		List<MedicalRecord> actual = hospital2.recordsFromPatientsWhoSuffered(migraña);
		assertEquals(expected, actual);
	}
	
	@Test
	public void whoSufferedConjuntivitisAlsoSuffered() {
		List<Disease> expected = new ArrayList<Disease>();
		expected.add(migraña);
		expected.add(conjuntivitis);
		List<Disease> actual = hospital2.whoSufferedXAlsoSufferedY(conjuntivitis);		
		assertEquals(expected, actual);
	}

}
