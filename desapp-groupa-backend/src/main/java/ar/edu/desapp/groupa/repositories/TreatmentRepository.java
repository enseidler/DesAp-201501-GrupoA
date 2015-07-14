package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.treatment.Treatment;

public class TreatmentRepository extends HibernateGenericDAO<Treatment> {

	private static final long serialVersionUID = -3813365820481179540L;

	@Override
	protected Class<Treatment> getDomainClass() {
		return Treatment.class;
	}

}
