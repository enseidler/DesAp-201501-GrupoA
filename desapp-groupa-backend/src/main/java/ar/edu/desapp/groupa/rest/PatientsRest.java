package ar.edu.desapp.groupa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.model.user.Patient;
import ar.edu.desapp.groupa.services.PatientService;

@Path("/patients")
public class PatientsRest {
	
	private PatientService patientService;

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

	@GET
    @Path("/all")
    @Produces("application/json")
    public List<Patient> retriveAll() {
        List<Patient> patients = patientService.retriveAll();
        return patients;
    }
	
}
