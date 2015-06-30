package ar.edu.desapp.groupa.model.system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.system.Hospital;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.user.Doctor;
import ar.edu.desapp.groupa.model.user.Patient;
import ar.edu.desapp.groupa.model.exceptions.NotFoundDiseaseException;
import ar.edu.desapp.groupa.model.exceptions.NotFoundMedicineException;
import ar.edu.desapp.groupa.model.exceptions.RecordExistException;
import static ar.edu.desapp.groupa.model.builders.DiseaseBuilder.*;

public class HospitalTest {
	
	private Hospital hospital1;
	private Hospital hospital2;
	private MedicalRecord medRecord1;
	private MedicalRecord medRecord2;
	private Symptom dolorDeCabeza;
	private Symptom dolorDeGarganta;
	private Symptom dolorDeEstomago;
	private Disease migraña;
	private Disease resfrio;
	private Disease conjuntivitis;
	private Patient patient1;
	private Patient patient2;
	private Doctor doctor1;
	private Drug aspirinaDrug;
	private Medicine aspirina;
	private MedicalPractice teEnLosOjos;
	
	
	@Before
	public void setUp() throws RuntimeException {
		
		// -Diseases- //
		dolorDeCabeza = mock(Symptom.class);
		dolorDeGarganta = mock(Symptom.class);
		dolorDeEstomago = mock(Symptom.class);
		migraña = aDisease("Migraña")
					.with(dolorDeCabeza)
					.build();
		resfrio = aDisease("Resfrio")
					.with(dolorDeCabeza)
					.with(dolorDeGarganta)
					.build();
		conjuntivitis = aDisease("Conjuntivitis").build();

		// -Records- //
		medRecord1 = mock(MedicalRecord.class);
		when(medRecord1.sufferedDisease(resfrio)).thenReturn(true);
		when(medRecord1.sufferedDisease(migraña)).thenReturn(true);
		when(medRecord1.sufferedDisease(conjuntivitis)).thenReturn(false);
		
		List<Disease> rec1Suffered = new ArrayList<Disease>();
		rec1Suffered.add(resfrio);
		rec1Suffered.add(migraña);
		when(medRecord1.getDiseases()).thenReturn(rec1Suffered);
		medRecord2 = mock(MedicalRecord.class);
		when(medRecord2.sufferedDisease(resfrio)).thenReturn(false);
		when(medRecord2.sufferedDisease(migraña)).thenReturn(true);
		when(medRecord2.sufferedDisease(conjuntivitis)).thenReturn(true);
		List<Disease> rec2Suffered = new ArrayList<Disease>();
		rec2Suffered.add(migraña);
		rec2Suffered.add(conjuntivitis);
		when(medRecord2.getDiseases()).thenReturn(rec2Suffered);
		
		// -People- //
		patient1 = mock(Patient.class);
		when(patient1.getMedicalRecord()).thenReturn(medRecord1);
		patient2 = mock(Patient.class);
		when(patient2.getMedicalRecord()).thenReturn(medRecord2);
		doctor1 = mock(Doctor.class);
		
		// -Treatment- //
		aspirinaDrug = mock(Drug.class);
		aspirina = mock(Medicine.class);
		when(aspirina.cure(resfrio)).thenReturn(true);
		when(aspirina.cure(conjuntivitis)).thenReturn(true);
		when(aspirina.instAllergic(medRecord1)).thenReturn(true);
		when(aspirina.instAllergic(medRecord2)).thenReturn(false);
		teEnLosOjos = mock(MedicalPractice.class);
		when(teEnLosOjos.cure(conjuntivitis)).thenReturn(true);
		
		// -System- //
		hospital1 = new Hospital();
		hospital1.addDisease(resfrio);
		hospital2 = new Hospital();
		hospital2.addDisease(resfrio);
		hospital2.addDisease(migraña);
		hospital2.addDisease(conjuntivitis);
		hospital2.addMedicine(aspirina);
		hospital2.addMedicalPractice(teEnLosOjos);
		hospital2.addPatient(patient1);
		hospital2.addPatient(patient2);
	
	}
	
	@Test
	public void addPatient_checkPatientTest() {
		hospital1.addPatient(patient1);
		Boolean condition = hospital1.getPatients().contains(patient1);
		assertTrue(condition);
	}
	
	@Test
	public void addPatient_checkMedicalRecordTest() {
		hospital1.addPatient(patient1);
		Boolean condition = hospital1.getMedicalRecords().contains(medRecord1);
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
	
	@Test /** @REQUIRED! */
	public void whoSufferedConjuntivitisAlsoSuffered() {
		List<Disease> expected = new ArrayList<Disease>();
		expected.add(migraña);
		expected.add(conjuntivitis);
		List<Disease> actual = hospital2.whoSufferedXAlsoSufferedY(conjuntivitis);		
		assertEquals(expected, actual);
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
	public void makeALazyDiagnosisTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		Disease expected = resfrio;
		Disease actual = hospital2.lazyDiagnosis(symptoms);
		assertEquals(expected, actual);
	}

	@Test(expected = NotFoundDiseaseException.class)
	public void cantMakeALazyDiagnosisTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeEstomago);
		hospital2.lazyDiagnosis(symptoms);
	}
	
	@Test
	public void matchsSymptomsMigrañaTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		Integer expected = 1;
		Integer actual = hospital2.matchs(migraña, symptoms);
		assertEquals(expected, actual);
	}

	@Test
	public void matchsSymptomsResfrioTest() {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		Integer expected = 2;
		Integer actual = hospital2.matchs(resfrio, symptoms);
		assertEquals(expected, actual);
	}
	
	@Test /** @REQUIRED! */
	public void makeATreatmentForPatientMedicineAssertTest() {
		Treatment treatment = hospital2.makeATreatmentFor(medRecord1,resfrio);
		Medicine expected = aspirina;
		Medicine actual = treatment.getMedicines().get(0); 
		assertEquals(expected, actual);
	}
	
	@Test(expected = NotFoundMedicineException.class) /** @REQUIRED! */
	public void cantMakeATreatmentForPatientMedicineAllergicAssertTest() {
		hospital2.makeATreatmentFor(medRecord2,resfrio); 
	}
	
	@Test(expected = NotFoundMedicineException.class) /** @REQUIRED! */
	public void cantMakeATreatmentForPatientMedicineNotExistAssertTest() {
		hospital2.makeATreatmentFor(medRecord1,migraña); 
	}
	
	@Test /** @REQUIRED! */
	public void makeATreatmentForPatientPracticeTest() {
		Treatment treatment = hospital2.makeATreatmentFor(medRecord1, conjuntivitis);
		MedicalPractice expected = teEnLosOjos;
		MedicalPractice actual = treatment.getMedicalPractices().get(0);
		assertEquals(expected, actual);
	}
	
	@Test /** @REQUIRED! */
	public void makeATreatmentForPatientPracticeNotExistTest() {
		Treatment treatment = hospital2.makeATreatmentFor(medRecord1, resfrio);
		Boolean condition = treatment.getMedicalPractices().isEmpty();
		assertTrue(condition);
	}
	
}
