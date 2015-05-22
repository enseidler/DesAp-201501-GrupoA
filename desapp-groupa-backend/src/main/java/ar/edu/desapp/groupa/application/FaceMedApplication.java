package ar.edu.desapp.groupa.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.desapp.groupa.services.GeneralService;
import ar.edu.desapp.groupa.services.PatientService;

public class FaceMedApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
		GeneralService gs = (GeneralService) context.getBean("services.general");
		PatientService ps = gs.getPatientService();
		System.out.println(ps.retriveAll().isEmpty());

	}

}