package ar.edu.desapp.groupa.services;

public class GeneralService {

	private PatientService patientService;
	
	private DoctorService doctorService;


	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

}
