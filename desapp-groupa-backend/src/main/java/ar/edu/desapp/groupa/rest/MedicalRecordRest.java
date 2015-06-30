package ar.edu.desapp.groupa.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.user.Patient;
import ar.edu.desapp.groupa.services.MedicalRecordService;


@Path("/records")
public class MedicalRecordRest {
	
	private MedicalRecordService medicalRecordService; 
	
	public void setMedicalRecordService(final MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public MedicalRecord getMedicalRecord(@PathParam("id") Integer id) {
		MedicalRecord record = medicalRecordService.findById(id);
		return record;
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPatient(MedicalRecord md) {
		medicalRecordService.save(md);
		return Response.ok(md).build();
	}

	@PUT
	@Path("/{id}/addAllergy")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addAllergy(@PathParam("id") Integer id, Drug drug) {
		MedicalRecord finalRecord = medicalRecordService.findById(id);
		finalRecord.addAllergy(drug);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
	
	@DELETE
	@Path("/{id}/deleteAllergy/{idAllergy}")
	@Produces("application/json")
	public Response deleteAllergy(@PathParam("id") Integer id, @PathParam("idAllergy") Integer idAllergy){
		MedicalRecord finalRecord = medicalRecordService.findById(id);
		finalRecord.deleteAllergyById(idAllergy);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
	
	
	
}