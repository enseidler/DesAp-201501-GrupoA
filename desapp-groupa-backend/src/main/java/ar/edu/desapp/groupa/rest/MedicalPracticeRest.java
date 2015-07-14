package ar.edu.desapp.groupa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.services.MedicalPracticeService;
import ar.edu.desapp.groupa.services.MedicineService;


@Path("/medicalPractices")
public class MedicalPracticeRest {
	
	private MedicalPracticeService medicalPracticeService;

	public void setMedicalPracticeService(MedicalPracticeService medicalPracticeService) {
		this.medicalPracticeService = medicalPracticeService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<MedicalPractice> getMedicalPractices() {
        List<MedicalPractice> medicalPractice = medicalPracticeService.retriveAll();
        return medicalPractice;
    }

}
