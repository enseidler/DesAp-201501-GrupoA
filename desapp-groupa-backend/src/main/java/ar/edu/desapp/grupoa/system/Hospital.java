package ar.edu.desapp.grupoa.system;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exeptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.medicalRecord.MedicalRecord;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.user.Doctor;
import ar.edu.desapp.grupoa.user.Patient;

public class Hospital {
	
	private List<MedicalRecord> medicalRecords;
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Disease> diseases;
	
	public Hospital(){
		this.medicalRecords = new ArrayList<MedicalRecord>();
		this.patients = new ArrayList<Patient>();
		this.doctors = new ArrayList<Doctor>();
		this.diseases = new ArrayList<Disease>();
	}
	
	
	public List<MedicalRecord> getMedicalConsultations() {
		return medicalRecords;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public List<Disease> getDiseases() {
		return diseases;
	}
	
	
///////////////////////////////////////////////////////////////////////////////
	
	public void addMedicalConsultations(MedicalRecord medicalRecords) {
		this.getMedicalConsultations().add(medicalRecords);
	}

	public void addPatient(Patient patient) {
		this.getPatients().add(patient);
	}

	public void addDoctor(Doctor doctor) {
		this.getDoctors().add(doctor);
	}
	
	public void addDiseases(Disease disease) {
		this.getDiseases().add(disease);
	}
	
	
	public void createNewMedicalConsultation(List<Symptom> symptoms) throws NotFoundDiseaseException{
		
		Doctor doctor = this.doctors.get(0);
		this.getDoctors().remove(0); //Lo asigno por lo tanto lo saco momentaneamente de la lista hasta q termine su trabajo
		
		MedicalConsultation newMedicalConsultation = new MedicalConsultation(doctor);
		doctor.addSymptomsToMedicalConsultation(newMedicalConsultation, symptoms);
		Disease disease = this.compareSymptoms(symptoms);
		doctor.addDignoseDisease(newMedicalConsultation, disease);
		
		doctor.addTreatment(newMedicalConsultation);
		
		this.addDoctor(doctor); // Termino su trabajo lo agrago denuevo a la lista
	
	}

	public Disease compareSymptoms(List<Symptom> symptoms) throws NotFoundDiseaseException{
		for(int x=0; x<this.getDiseases().size(); x++) {
			Disease disease = this.getDiseases().get(x);
			if(symptoms.containsAll(disease.getSymptoms())){
				return disease;
			}
		}
		throw new NotFoundDiseaseException("Not Found Disease");
	}

	
}


