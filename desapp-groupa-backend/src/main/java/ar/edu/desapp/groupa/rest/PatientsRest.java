package ar.edu.desapp.groupa.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("/list")
    @Produces("application/json")
    public List<Patient> getPatients() {
        List<Patient> patients = patientService.retriveAll();
        return patients;
    }
	
	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	public void createPatient(@FormParam("name") String name, 
								@FormParam("surname") String surname,
								@FormParam("dni") Integer dni,
								@FormParam("password") String password,
								@FormParam("weight") double weight,
								@FormParam("height") double height) {
		patientService.save(new Patient(name, surname, dni, password, weight, height));
	}
	
}