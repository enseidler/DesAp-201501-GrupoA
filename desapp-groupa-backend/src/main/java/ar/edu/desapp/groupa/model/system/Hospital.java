package ar.edu.desapp.groupa.model.system;

import java.util.ArrayList;
import java.util.List;

import static ar.edu.desapp.groupa.model.builders.DiseaseBuilder.*;
import static ar.edu.desapp.groupa.model.utils.ListUtils.*;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.exceptions.NotFoundDiseaseException;
import ar.edu.desapp.groupa.model.exceptions.NotFoundMedicineException;
import ar.edu.desapp.groupa.model.exceptions.RecordExistException;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.user.Doctor;
import ar.edu.desapp.groupa.model.user.Patient;

public class Hospital {
	
	private List<MedicalRecord> medicalRecords;
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Disease> diseases;
	private List<Medicine> medicines;
	private List<MedicalPractice> medicalPractices;
	
	public Hospital(){
		this.medicalRecords = new ArrayList<MedicalRecord>();
		this.patients = new ArrayList<Patient>();
		this.doctors = new ArrayList<Doctor>();
		this.diseases = new ArrayList<Disease>();
		this.medicines = new ArrayList<Medicine>();
		this.medicalPractices = new ArrayList<MedicalPractice>();
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
	
	public List<Medicine> getMedicines() {
		return medicines;
	}

	public List<MedicalPractice> getMedicalPractices() {
		return medicalPractices;
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	public void addMedicalRecord(Patient patient) {

		this.getMedicalRecords().add(patient.getMedicalRecord());	
	}
	
	public void addPatient(Patient patient) {
		this.getPatients().add(patient);
		this.addMedicalRecord(patient);
	}

	public void addDoctor(Doctor doctor) {
		this.getDoctors().add(doctor);
	}
	
	public void addDisease(Disease disease) {
		this.getDiseases().add(disease);
	}
	
	public void addMedicine(Medicine medicine) {
		this.getMedicines().add(medicine);
	}
	
	public void addMedicalPractice(MedicalPractice medicalPractice) {
		this.getMedicalPractices().add(medicalPractice);
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
	
	public Treatment makeATreatmentFor(MedicalRecord medicalRecord, Disease disease) {
		Treatment treatment = new Treatment();
		treatment.addMedicine(this.chooseMedicine(medicalRecord, disease));
		MedicalPractice medPractice = this.chooseMedicalPractice(medicalRecord, disease);
		if(medPractice != null) {
			treatment.addMedicalPractices(medPractice);
		}
		return treatment;
	}


	public Medicine chooseMedicine(MedicalRecord medicalRecord, Disease disease) throws NotFoundMedicineException {
		for(Medicine med : this.getMedicines()) {
			if(med.cure(disease) && med.instAllergic(medicalRecord)) {
				return med;
			}
		}
		throw new NotFoundMedicineException();
	}

	public MedicalPractice chooseMedicalPractice(MedicalRecord medicalRecord, Disease disease) {
		for(MedicalPractice medPractice : this.getMedicalPractices()) {
			if(medPractice.cure(disease)) {
				return medPractice;
			}
		}
		return null;
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


