package ar.edu.desapp.groupa.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.services.MedicineService;


@Path("/medicines")
public class MedicineRest {
	
	private MedicineService medicineService;

	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}
	
	@GET
    @Path("/list")
    @Produces("application/json")
    public List<Medicine> getMedicines() {
        List<Medicine> medicines = medicineService.retriveAll();
        return medicines;
    }

}
