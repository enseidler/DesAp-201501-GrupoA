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

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.services.DiseaseService;
import ar.edu.desapp.groupa.services.MedicalRecordService;


@Path("/records")
public class MedicalRecordRest {
	
	private MedicalRecordService medicalRecordService; 
	private DiseaseService diseaseService;
	
	
	public void setMedicalRecordService(final MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	public void setDiseaseService(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
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
	
	@PUT
	@Path("/{id}/deleteAllergy/{idAllergy}")
	@Produces("application/json")
	public Response deleteAllergy(@PathParam("id") Integer id, @PathParam("idAllergy") Integer idAllergy){
		MedicalRecord finalRecord = medicalRecordService.findById(id);
		finalRecord.deleteAllergyById(idAllergy);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
	
	@PUT
	@Path("/{id}/addDisease")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addDisease(@PathParam("id") Integer id, Disease disease) {
		MedicalRecord finalRecord = medicalRecordService.findById(id);
		finalRecord.addDisease(disease);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
	
	@PUT
	@Path("/{id}/deleteDisease/{idDisease}")
	@Produces("application/json")
	public Response deleteDisease(@PathParam("id") Integer id, @PathParam("idDisease") Integer idDisease){
		MedicalRecord finalRecord = medicalRecordService.findById(id);
		finalRecord.deleteDiseaseById(idDisease);
		medicalRecordService.update(finalRecord);
		return Response.ok(finalRecord).build();
	}
	
	@PUT
	@Path("/{medicalRecordId}/createConsultation/{diseaseId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createConsultation(
			@PathParam("medicalRecordId") Integer medicalRecordId,
			@PathParam("diseaseId") Integer diseaseId,
			Treatment treatment) {
		MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecordId);
		Disease diagnosedDisease = diseaseService.findById(diseaseId);
		MedicalConsultation finalMedicalConsultation = new MedicalConsultation();
		finalMedicalConsultation.addTreatment(treatment);
		finalMedicalConsultation.addDiagnoseDisease(diagnosedDisease);
		medicalRecord.addConsultation(finalMedicalConsultation);
		medicalRecordService.update(medicalRecord);
		return Response.ok(medicalRecord).build();
	}
	
}