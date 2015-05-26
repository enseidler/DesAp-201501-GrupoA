package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.symptom.Symptom;

public class SymptomRepository extends HibernateGenericDAO<Symptom> implements GenericRepository<Symptom> {

	private static final long serialVersionUID = -5570368642086373827L;

	@Override
	protected Class<Symptom> getDomainClass() {
		return Symptom.class;
	}

}
