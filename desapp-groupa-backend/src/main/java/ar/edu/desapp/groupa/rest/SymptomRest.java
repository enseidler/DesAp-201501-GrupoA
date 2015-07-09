package ar.edu.desapp.groupa.rest;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.services.SymptomService;


@Path("/symptoms")
public class SymptomRest {
	
	private SymptomService symptomService; 
	
	public void setSymptomService(final SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Symptom> list() {
		List<Symptom> symptoms = symptomService.retriveAll();
		return symptoms;
	}
	
}