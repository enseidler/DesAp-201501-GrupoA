package ar.edu.desapp.groupa.helpers;

import java.util.List;

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.treatment.Treatment;

public class TreatmentHelper {
	public static Treatment diagnose(MedicalRecord medicalRecord,
			Disease diagnosedDisease, List<Medicine> medicines,
			List<MedicalPractice> medicalPractices) {
		Treatment treatment = new Treatment();
		if (diagnosedDisease.haveATreatment(medicalRecord)) {
			treatment = diagnosedDisease.getTreatments().get(0);
		} else {
			Medicine medicine = chooseMedicine(medicalRecord, diagnosedDisease, medicines);
			if(medicine != null) {
				treatment.addMedicine(medicine);
			}
			MedicalPractice medPractice = chooseMedicalPractice(medicalRecord, diagnosedDisease, medicalPractices);
			if(medPractice != null) {
				treatment.addMedicalPractices(medPractice);
			}
		}
		return treatment;
	}


	public static Medicine chooseMedicine(MedicalRecord medicalRecord, Disease disease, List<Medicine> medicines){
		for(Medicine medicine : medicines) {
			if(medicine.cure(disease) && medicine.instAllergic(medicalRecord)) {
				return medicine;
			}
		}
		return null;
	}

	public static MedicalPractice chooseMedicalPractice(MedicalRecord medicalRecord, Disease disease, List<MedicalPractice> medicalPractices) {
		for(MedicalPractice medPractice : medicalPractices) {
			if(medPractice.cure(disease)) {
				return medPractice;
			}
		}
		return null;
	}
	
}
