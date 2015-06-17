package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.medicine.Drug;

public class DrugRepository extends HibernateGenericDAO<Drug> implements GenericRepository<Drug> {
	
	private static final long serialVersionUID = 2562609189135520123L;

	@Override
	protected Class<Drug> getDomainClass() {
		return Drug.class;
	}

}
