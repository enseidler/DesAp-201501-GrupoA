package ar.edu.desapp.groupa.rest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.services.MedicalConsultationService;
import ar.edu.desapp.groupa.services.MedicalRecordService;

@Path("/consultations")
public class MedicalConsultationRest {
	
	private MedicalConsultationService medicalConsultationService; 
	public MedicalRecordService medicalRecordService; 
	
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
	
}
