package ar.edu.desapp.grupoa.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.treatment.Treatment;
import ar.edu.desapp.grupoa.user.Doctor;


public class MedicalConsultationBuilder {
	
	private Doctor doctor = null;
	private List<Symptom> symptoms = new ArrayList<Symptom>();
	private Disease dignoseDisease = null;
	private Treatment treatment = null;
	
	public static MedicalConsultationBuilder aMedicalRecord(Doctor doctor) {
		return new MedicalConsultationBuilder(doctor);
	}
	
	public MedicalConsultationBuilder(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public MedicalConsultation build() {
		MedicalConsultation medicalConsultation = new MedicalConsultation(this.doctor);
		return medicalConsultation;
	}
	
	public MedicalConsultationBuilder with(final Symptom symptom) {
		this.symptoms.add(symptom);
		return this;
	}
	
	public MedicalConsultationBuilder with(final Treatment treatment) {
		this.treatment = treatment;
		return this;
	}
	
	public MedicalConsultationBuilder with(final Disease disease) {
		this.dignoseDisease = disease;
		return this;
	}

}
