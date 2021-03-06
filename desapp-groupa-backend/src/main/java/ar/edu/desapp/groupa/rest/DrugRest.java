package ar.edu.desapp.groupa.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.services.DrugService;


@Path("/drugs")
public class DrugRest {
	
	private DrugService drugService;
	
	public void setDrugService(final DrugService drugService) {
		this.drugService = drugService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<Drug> getDrugs() {
        List<Drug> drugs = drugService.retriveAll();
        return drugs;
    }
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createDrug(Drug drug) {
		drugService.save(drug);
		return Response.ok(drug).build();
	}

	
}