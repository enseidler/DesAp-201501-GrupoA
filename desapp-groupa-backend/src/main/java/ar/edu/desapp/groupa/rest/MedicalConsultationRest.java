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

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.services.MedicalConsultationService;
import ar.edu.desapp.groupa.services.MedicalRecordService;

@Path("/consultations")
public class MedicalConsultationRest {
	

	private MedicalConsultationService medicalConsultationService; 
	private MedicalRecordService medicalRecordService; 
	
	public void setMedicalConsultationService(
			MedicalConsultationService medicalConsultationService) {
		this.medicalConsultationService = medicalConsultationService;
	}

	public void setMedicalRecordService(final MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<MedicalConsultation> getMedicalCosultation() {
        List<MedicalConsultation> medicalConsultation = medicalConsultationService.retriveAll();
        return medicalConsultation;
    }

	@PUT
	@Path("/create/{medicalRecordId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(@PathParam("medicalRecordId") Integer medicalRecordId,
			Treatment treatment, Disease disease) {
		MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecordId);
		MedicalConsultation finalMedicalConsultation = new MedicalConsultation();
		finalMedicalConsultation.addTreatment(treatment);
		medicalRecord.addConsultation(finalMedicalConsultation);
		medicalRecordService.update(medicalRecord);
		return Response.ok(medicalRecord).build();
	}
	
}
