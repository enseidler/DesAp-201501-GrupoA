package ar.edu.desapp.groupa.services;

import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.user.Patient;
import static ar.edu.desapp.groupa.model.builders.DiseaseBuilder.*;
import static ar.edu.desapp.groupa.model.builders.MedicineBuilder.*;
import static ar.edu.desapp.groupa.model.builders.MedicalPracticeBuilder.*;
import static ar.edu.desapp.groupa.application.FaceMedApplication.*;

public class GeneralService {

	private PatientService patientService;
	private SymptomService symptomService;
	private DiseaseService diseaseService;
	private MedicalConsultationService medicalConsultationService;
	private MedicalRecordService medicalRecordService;
	private DrugService drugService;
	private MedicineService medicineService;
	private MedicalPracticeService medicalPracticeService;

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
//		this.getPatientService().save(patient());
		this.getPatientService().save(new Patient("Cacho", "Castaña", 1111111, "cafelahumeda", 80, 1.7));
		this.getPatientService().save(new Patient("Ramona", "Gutierrez", 2222222, "753214896", 56.7, 1.67));
		this.getPatientService().save(new Patient("Santiago", "Ramirez", 3333333, "951478632", 84.5, 1.82));
		this.getPatientService().save(new Patient("Brenda", "Gomez", 444444, "321987654", 48, 1.62));
		this.getPatientService().save(new Patient("Hernan", "Garcia", 5555555, "987321654", 79, 1.8));
		this.getPatientService().save(new Patient("Paula", "Torrez", 6666666, "987654321", 60, 1.6));
		this.getPatientService().save(new Patient("Pablo", "Garcia", 7777777, "123456789", 98, 1.9));
	}

	public SymptomService getSymptomService() {
		return symptomService;
	}

	public void setSymptomService(final SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	public DiseaseService getDiseaseService() {
		return diseaseService;
	}

	public void setDiseaseService(final DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
		this.getDiseaseService().save(aDisease("Varicela")
				.with(new Symptom("Erupciones en la piel"))
				.with(new Symptom("Dolor de Cabeza"))
				.with(new Symptom("Fiebre"))
				.build());
		this.getDiseaseService().save(aDisease("Diarrea")
				.with(new Symptom("Dolor de Estomago"))
				.with(new Symptom("Deshidratacion"))
				.with(new Symptom("Cacona floja"))
				.build());
	}

	public MedicalConsultationService getMedicalConsultationService() {
		return medicalConsultationService;
	}

	public void setMedicalConsultationService(final MedicalConsultationService medicalConsultationService) {
		this.medicalConsultationService = medicalConsultationService;
	}

	public MedicalRecordService getMedicalRecordService() {
		return medicalRecordService;
	}

	public void setMedicalRecordService(MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	public DrugService getDrugService() {
		return drugService;
	}

	public void setDrugService(DrugService drugService) {
		this.drugService = drugService;
	}

	public MedicineService getMedicineService() {
		return medicineService;
	}

	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
		this.getMedicineService().save(aMedicine()
								.with(new Drug("Ibuprofeno"))
								.with(600)
								.build());
		this.getMedicineService().save(aMedicine()
								.with(new Drug("Antidiarreico"))
								.with(300)
								.build());
	}

	public MedicalPracticeService getMedicalPracticeService() {
		return medicalPracticeService;
	}

	public void setMedicalPracticeService(
			MedicalPracticeService medicalPracticeService) {
		this.medicalPracticeService = medicalPracticeService;
		this.getMedicalPracticeService().save(aMedicalPractice()
										.withName("Aplicar paños frios sobre las ampollas")
										.build());
	}
}
