package ar.edu.desapp.groupa.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Drug;
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
	@Path("/modifyAllergy")
	@Consumes("application/json")
	@Produces("application/json")
	public Response modifyPatient(MedicalRecord record, Drug allergy) {
		MedicalRecord finalRecord = medicalRecordService.findById(record.getId());
		finalRecord.addAllergy(allergy);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
}