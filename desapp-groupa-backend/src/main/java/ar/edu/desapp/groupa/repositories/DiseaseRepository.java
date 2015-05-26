package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.disease.Disease;

public class DiseaseRepository extends HibernateGenericDAO<Disease> implements GenericRepository<Disease> {
	
	private static final long serialVersionUID = 100179505074083692L;

	@Override
	protected Class<Disease> getDomainClass() {
		return Disease.class;
	}

}
