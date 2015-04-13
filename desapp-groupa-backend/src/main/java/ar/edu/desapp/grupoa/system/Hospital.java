package ar.edu.desapp.grupoa.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ar.edu.desapp.grupoa.utils.ListUtils.*;
import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exeptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.exeptions.RecordExistException;
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
	
	/*
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
	*/
	
	
	///////
	
	
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
	 * @MISSING TESTS
	 */
	public Disease moreProbableDiagnosis(List<Symptom> symptoms) {
		Disease probDiagnosis = this.getDiseases().get(0); 
		for(Disease disease : this.getDiseases()) {
			if(matchs(disease, symptoms) > matchs(probDiagnosis, symptoms)) {
				probDiagnosis = disease;
			}
		}
		if(matchs(probDiagnosis,symptoms) > 0) {
			return probDiagnosis;			
		} else {
			throw new NotFoundDiseaseException();
		}
	}
	
	/**
	 * @MISSING TESTS
	 */
	public Integer matchs(Disease disease, List<Symptom> symptoms) {
		return (intersection(disease.getSymptoms(), symptoms)).size();
	}
	
}


