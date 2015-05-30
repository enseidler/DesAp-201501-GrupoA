package ar.edu.desapp.groupa.services;

import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.user.Patient;


public class GeneralService {

	private PatientService patientService;
	private SymptomService symptomService;
	private DiseaseService diseaseService;
	private MedicalConsultationService medicalConsultationService;
	private MedicalRecordService medicalRecordServices;

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
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
		this.getSymptomService().save(new Symptom("Dolor de Cabeza"));
		this.getSymptomService().save(new Symptom("Dolor de Estomago"));
		this.getSymptomService().save(new Symptom("Dolor de Garganta"));
		this.getSymptomService().save(new Symptom("Fiebre"));
		this.getSymptomService().save(new Symptom("Erupciones en la piel"));
		this.getSymptomService().save(new Symptom("Diarrea"));
		this.getSymptomService().save(new Symptom("Vomitos"));
	}

	public DiseaseService getDiseaseService() {
		return diseaseService;
	}

	public void setDiseaseService(final DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public MedicalConsultationService getMedicalConsultationService() {
		return medicalConsultationService;
	}

	public void setMedicalConsultationService(final MedicalConsultationService medicalConsultationService) {
		this.medicalConsultationService = medicalConsultationService;
	}

	public MedicalRecordService getMedicalRecordServices() {
		return medicalRecordServices;
	}

	public void setMedicalRecordServices(MedicalRecordService medicalRecordServices) {
		this.medicalRecordServices = medicalRecordServices;
	}
}
