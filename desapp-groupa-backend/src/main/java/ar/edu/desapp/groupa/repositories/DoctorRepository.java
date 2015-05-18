package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.user.Doctor;

public class DoctorRepository extends HibernateGenericDAO<Doctor> implements GenericRepository<Doctor> {

	private static final long serialVersionUID = 5439912862512857029L;

	@Override
	protected Class<Doctor> getDomainClass() {
		return Doctor.class;
	}

}
