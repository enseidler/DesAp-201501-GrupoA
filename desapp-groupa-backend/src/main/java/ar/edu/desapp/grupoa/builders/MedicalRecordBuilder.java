package ar.edu.desapp.grupoa.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.medicalRecord.MedicalRecord;
import ar.edu.desapp.grupoa.medicine.Drug;
import ar.edu.desapp.grupoa.user.Patient;

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
		MedicalRecord medicalRecord = new MedicalRecord(this.patient);
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
