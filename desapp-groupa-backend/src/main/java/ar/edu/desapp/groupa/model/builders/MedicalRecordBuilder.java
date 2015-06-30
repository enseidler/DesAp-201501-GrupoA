package ar.edu.desapp.groupa.model.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.user.Patient;

public class MedicalRecordBuilder {

	private Patient patient = null;
	private List<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	private List<Disease> diseases = new ArrayList<Disease>();
	private List<Drug> allergies = new ArrayList<Drug>();

	public static MedicalRecordBuilder aMedicalRecord(Patient patient) {
		return new MedicalRecordBuilder(patient);
	}
	
	public MedicalRecordBuilder(Patient patient) {
		this.patient = patient;
	}
	
	public MedicalRecord build() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setAllergies(this.allergies);
		medicalRecord.setConsultations(this.consultations);
		medicalRecord.setDiseases(this.diseases);
		return medicalRecord;
	}
	
	public MedicalRecordBuilder with(final MedicalConsultation mc) {
		this.consultations.add(mc);
		return this;
	}
	
	public MedicalRecordBuilder with(final Disease d) {
		this.diseases.add(d);
		return this;
	}
	
	public MedicalRecordBuilder with(final Drug d) {
		this.allergies.add(d);
		return this;
	}
}
