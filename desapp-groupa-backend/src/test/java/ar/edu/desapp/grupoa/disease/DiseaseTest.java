package ar.edu.desapp.grupoa.disease;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DiseaseTest {
	
	private Disease disease;
	
	@Before
	public void setUp(){
		disease = new Disease("Migraña");
	}

	@Test
	public void diseaseDataNameTest(){
		String expected = "Migraña";
		assertEquals(expected, disease.getName());
	}
}
