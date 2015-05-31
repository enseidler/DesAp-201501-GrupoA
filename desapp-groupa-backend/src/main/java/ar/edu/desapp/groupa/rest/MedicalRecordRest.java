package ar.edu.desapp.groupa.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.services.MedicalRecordService;


@Path("/records")
public class MedicalRecordRest {
	
	private MedicalRecordService medicalRecordService; 
	
	public void setMedicalRecordService(final MedicalRecordService recordService) {
		this.medicalRecordService = recordService;
	}

	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public MedicalRecord getMedicalRecord(@PathParam("id") Integer id) {
		MedicalRecord record = medicalRecordService.findById(id);
		return record;
	}
	

	
}