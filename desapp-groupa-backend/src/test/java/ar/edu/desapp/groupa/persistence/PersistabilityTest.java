package ar.edu.desapp.groupa.persistence;



import static org.junit.Assert.*;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="persistence.transactionManager")
@ContextConfiguration(locations = "classpath:META-INF/spring-persistence-context.xml")
public class PersistabilityTest{

	@Autowired
	private SessionFactory sessionFactory;

    @Before
    public void setUp() {
    	sessionFactory.openSession();
    }
    
    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void entitiesTest() {
        Map metadata = sessionFactory.getAllClassMetadata();
        for (Object entity : metadata.values()) {
            EntityPersister persister = (EntityPersister)entity;
            String className = persister.getEntityName();
            assertTrue(isMyModelEntitie(className));
        }
	 }
	
	 public boolean isMyModelEntitie(String nameClass){
		 return (nameClass.equals("ar.edu.desapp.groupa.model.disease.Disease") ||
				 nameClass.equals("ar.edu.desapp.groupa.model.medicine.Drug") ||
				 nameClass.equals("ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation") ||
				 nameClass.equals("ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice") ||
				 nameClass.equals("ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord") ||
				 nameClass.equals("ar.edu.desapp.groupa.model.medicine.Medicine")||
				 nameClass.equals("ar.edu.desapp.groupa.model.user.Patient")||
				 nameClass.equals("ar.edu.desapp.groupa.model.symptom.Symptom")||
				 nameClass.equals("ar.edu.desapp.groupa.model.treatment.Treatment"));
	 }

}

