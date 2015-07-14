package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;

public class MedicalPracticeRepository extends
		HibernateGenericDAO<MedicalPractice> {

	private static final long serialVersionUID = -4210163036972207029L;

	@Override
	protected Class<MedicalPractice> getDomainClass() {
		return MedicalPractice.class;
	}

}
