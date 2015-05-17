package ar.edu.desapp.groupa.services;

public class GeneralService {

	private PatientService patientService;


	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

}
