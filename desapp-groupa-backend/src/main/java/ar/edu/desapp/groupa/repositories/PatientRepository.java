package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.user.Patient;

public class PatientRepository extends HibernateGenericDAO<Patient> implements GenericRepository<Patient> {

	private static final long serialVersionUID = -5498991736518958393L;

	
	@Override
	protected Class<Patient> getDomainClass() {
		return Patient.class;
	}

}
