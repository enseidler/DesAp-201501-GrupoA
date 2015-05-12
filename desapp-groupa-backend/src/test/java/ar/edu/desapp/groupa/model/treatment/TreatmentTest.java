package ar.edu.desapp.groupa.model.treatment;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.repose.Parcial;
import ar.edu.desapp.groupa.model.repose.Total;
import static ar.edu.desapp.groupa.model.builders.TreatmentBuilder.*;

public class TreatmentTest {
	
	private Parcial parcialRepose;
	private Total totalRepose;
	private Treatment treatment1;
	private Treatment treatment2;
	private Medicine medicine;
	private MedicalPractice medicalPractice;
	
	@Before
	public void setUp(){
		
		parcialRepose = mock(Parcial.class);
		totalRepose = new Total();
		//treatment1 = new Treatment(parcialRepose);
		//treatment2 = new Treatment(totalRepose);
		medicalPractice = mock(MedicalPractice.class);
		medicine = mock(Medicine.class);
		
		
		treatment1 = aTreatment(parcialRepose).build();
		treatment2 = aTreatment(totalRepose).build();
		
		
	}
	
	@Test
	public void treatmentRepose01Test(){
		Parcial expected = parcialRepose;
		assertEquals(expected, treatment1.getRepose());
	}
	
	@Test
	public void treatmentRepose02Test(){
		Total expected = totalRepose;
		assertEquals(expected, treatment2.getRepose());
	}
	
	@Test
	public void addMedicineTest() {
		treatment1.addMedicine(medicine);
		boolean expected = treatment1.getMedicines().contains(medicine);
		assertTrue(expected);
	}
	
	@Test
	public void addMedicalPracticeTest() {
		treatment1.addMedicalPractices(medicalPractice);
		boolean expected = treatment1.getMedicalPractices().contains(medicalPractice);
		assertTrue(expected);
	}

}
