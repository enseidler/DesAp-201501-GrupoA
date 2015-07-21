package ar.edu.desapp.groupa.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.desapp.groupa.helpers.DiagnoseHelper;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.user.Patient;
import ar.edu.desapp.groupa.model.utils.FaceMedUtils;
import ar.edu.desapp.groupa.services.DiseaseService;
import ar.edu.desapp.groupa.services.SymptomService;


@Path("/diseases")
public class DiseaseRest {
	
	private DiseaseService diseaseService;
	private SymptomService symptomService; 

	
	public void setDiseaseService(final DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}
	
	public void setSymptomService(final SymptomService symptomService) {
		this.symptomService = symptomService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<Disease> getDiseases() {
        List<Disease> diseases = diseaseService.retriveAll();
        return diseases;
    }
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Disease getDisease(@PathParam("id") Integer id) {
		Disease disease = diseaseService.findById(id);
		return disease;
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createDisease(Disease disease) {
		diseaseService.save(disease);
		return Response.ok(disease).build();
	}

	@POST
    @Path("/create/{idsSymptoms}")
	@Consumes("application/json")
    @Produces("application/json")
    public Response createDiseae(@PathParam("idsSymptoms") String idsSymptoms, Disease disease) {
        List<Integer> ids = FaceMedUtils.getIntsFromString(idsSymptoms);
        List<Symptom> currentSymptoms = symptomService.retriveAllById(ids);
		disease.setSymptoms(currentSymptoms);
		diseaseService.save(disease);
        return Response.ok(disease).build();
	}
	
	
}