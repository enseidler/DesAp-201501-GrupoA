package ar.edu.desapp.grupoa.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ar.edu.desapp.grupoa.builders.DiseaseBuilder.*;
import static ar.edu.desapp.grupoa.utils.ListUtils.*;
import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exceptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.exceptions.RecordExistException;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.medicalRecord.MedicalRecord;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.treatment.Treatment;
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
	
	
	public List<MedicalRecord> getMedicalRecords() {
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
	
	public void addMedicalRecord(MedicalRecord medicalRecord) throws RecordExistException {
		if(!existRecordFor(medicalRecord.getPatient())) {
			this.getMedicalRecords().add(medicalRecord);
		} else {
			throw new RecordExistException();
		}
	}
	
	public void addPatient(Patient patient) {
		this.getPatients().add(patient);
	}

	public void addDoctor(Doctor doctor) {
		this.getDoctors().add(doctor);
	}
	
	public void addDisease(Disease disease) {
		this.getDiseases().add(disease);
	}
	
	public Boolean existRecordFor(Patient patient) {
		Boolean exist = false;
		for(MedicalRecord rec : this.getMedicalRecords()) {
			exist = exist || (rec.getPatient() == patient);
		}
		return exist;
	}
	
	public List<MedicalRecord> recordsFromPatientsWhoSuffered(Disease disease) {
		List<MedicalRecord> recs = new ArrayList<MedicalRecord>();
		for(MedicalRecord rec : this.getMedicalRecords()) {
			if(rec.sufferedDisease(disease)) {
				recs.add(rec);
			}
		}
		return recs;
	}
	
	public List<Disease> whoSufferedXAlsoSufferedY(Disease disease) {
		List<Disease> result = new ArrayList<Disease>();
		for(MedicalRecord rec : this.recordsFromPatientsWhoSuffered(disease)) {
			addWhatNotExist(result, rec.getDiseases());
		}
		return result;
	}

	/**
	 * @param symptoms
	 * @return possible diseases for a given symptoms list
	 * @criteria if a disease has one symptom from list, could be a correct diagnosis
	 */
	public List<Disease> possibleDiseases(List<Symptom> symptoms) {
		List<Disease> result = new ArrayList<Disease>();
		for(Disease disease : this.getDiseases()) {
			if(disease.hasASymptom(symptoms)) {
				addIfNotExist(result,disease);
			}
		}
		return result;
	}
	
	public Disease lazyDiagnosis(List<Symptom> symptoms) {
		List<Disease> possibles = this.possibleDiseases(symptoms);
		Disease probDiagnosis = aDisease("unknown").build();
		if(!possibles.isEmpty()) {
			for(Disease disease : possibles) {
				if(matchs(disease, symptoms) > matchs(probDiagnosis, symptoms)) {
					probDiagnosis = disease;
				}
			}
		} else {
			throw new NotFoundDiseaseException();
		}
		return probDiagnosis;			
	}
	
	public Integer matchs(Disease disease, List<Symptom> symptoms) {
		return (intersection(disease.getSymptoms(), symptoms)).size();
	}
	
	/*
	 * 
	 * Caso de uso de doctor (Consulta completa)
	 * Para un paciente X
	 * Hay que conseguir los sintomas del paciente
	 * Hay que conseguir la enfermedad diagnosticada
	 * Hay que conseguir el tratamiento para el diagnostico
	 * Resultado final: 
	 * 		1- Retorna una MedicalConsultation con
	 * 					-Doctor
	 * 					-Paciente
	 * 					-Enfermedad diagnosticada
	 * 					-Tratamiento correcto
	 * 
	 * 		2- Agrega la MedicalConsultation a la historia clinica del paciente
	 * 		3- Agrega la enfermedad diagnosticada a la historia clinica	
	 * 
	 */
	
}


