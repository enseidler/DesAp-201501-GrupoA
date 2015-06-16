package ar.edu.desapp.groupa.rest;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;

import ar.edu.desapp.groupa.services.MedicalConsultationService;

@Path("/consultations")
public class MedicalConsultationRest {
	
	private MedicalConsultationService medicalConsultationService; 
	
	public void setMedicalConsultationService(final MedicalConsultationService medicalConsultationService) {
		this.medicalConsultationService = medicalConsultationService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<MedicalConsultation> getMedicalCosultation() {
        List<MedicalConsultation> medicalConsultation = medicalConsultationService.retriveAll();
        return medicalConsultation;
    }

	
}