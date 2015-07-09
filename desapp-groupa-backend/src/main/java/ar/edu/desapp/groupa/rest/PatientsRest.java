package ar.edu.desapp.groupa.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Patient getPatient(@PathParam("id") Integer id) {
		Patient patient = patientService.findById(id);
		return patient;
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPatient(Patient patient) {
		patientService.save(patient);
		return Response.ok(patient).build();
	}
	
	@PUT
	@Path("/modify")
	@Consumes("application/json")
	@Produces("application/json")
	public Response modifyPatient(Patient patient) {
		Patient finalPatient = patientService.findById(patient.getId());
		finalPatient.setName(patient.getName());
		finalPatient.setSurname(patient.getSurname());
		finalPatient.setDni(patient.getDni());
		finalPatient.setHeight(patient.getHeight());
		finalPatient.setWeight(patient.getWeight());
		finalPatient.setPassword(patient.getPassword());
		patientService.update(finalPatient);
		return Response.ok(finalPatient).build();
	}
	
}