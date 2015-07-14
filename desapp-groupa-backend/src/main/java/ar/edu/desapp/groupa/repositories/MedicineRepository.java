package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.medicine.Medicine;

public class MedicineRepository extends HibernateGenericDAO<Medicine> {

	private static final long serialVersionUID = -6651799097371268667L;

	@Override
	protected Class<Medicine> getDomainClass() {
		return Medicine.class;
	}

}
