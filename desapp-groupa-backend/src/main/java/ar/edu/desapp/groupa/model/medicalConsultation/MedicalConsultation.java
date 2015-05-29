package ar.edu.desapp.groupa.model.medicalConsultation;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.user.Doctor;

public class MedicalConsultation extends Entity {
	
	private static final long serialVersionUID = 745361633878607081L;
	
	private Doctor doctor;
	private Disease diagnoseDisease = null;
	private Treatment treatment = null;
	
	public MedicalConsultation() {
		super();
	}
	
	public MedicalConsultation(Doctor doctor) {
		super();
		this.doctor = doctor;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Disease getDiagnoseDisease() {
		return diagnoseDisease;
	}

	public void setDiagnoseDisease(Disease diagnoseDisease) {
		this.diagnoseDisease = diagnoseDisease;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	///////////////////////////////////////////////////////

	public void addTreatment(Treatment treatament) {
		this.treatment = treatament;
	}
	
	public void addDiagnoseDisease(Disease diagnoseDiase) {
		this.diagnoseDisease = diagnoseDiase;
	}
	
}
