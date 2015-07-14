package ar.edu.desapp.groupa.rest;


import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.helpers.DiagnoseHelper;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.utils.FaceMedUtils;
import ar.edu.desapp.groupa.services.DiseaseService;
import ar.edu.desapp.groupa.services.SymptomService;

@Path("/diagnose")
public class DiagnoseRest {
	
	private DiseaseService diseaseService; 
	private SymptomService symptomService; 
	
	public void setDiseaseService(final DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public void setSymptomService(final SymptomService symptomService) {
		this.symptomService = symptomService;
	}
	
	@GET
    @Path("/diagnosedDiseases{idsSymptoms : (/idsSymptoms)?}")
	@Consumes("application/json")
    @Produces("application/json")
    public List<Disease> getDiagnosedDiseases(@PathParam("idsSymptoms") String idsSymptoms) {
        List<Disease> diseases = diseaseService.retriveAll();
        List<Integer> ids = FaceMedUtils.getIntsFromString(idsSymptoms);
        List<Symptom> currentSymptoms = symptomService.retriveAllById(ids);
		List<Disease> diagnosedDiseases = DiagnoseHelper.diagnose(diseases, currentSymptoms);
		return diagnosedDiseases;
	}
	
}