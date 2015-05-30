package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;

public class MedicalRecordRepository extends HibernateGenericDAO<MedicalRecord> implements GenericRepository<MedicalRecord> {
	

	private static final long serialVersionUID = -2060061737182731614L;

	@Override
	protected Class<MedicalRecord> getDomainClass() {
		return MedicalRecord.class;
	}

}
