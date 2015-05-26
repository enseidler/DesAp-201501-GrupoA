package ar.edu.desapp.groupa.repositories;

import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;

public class MedicalConsultationRepository extends HibernateGenericDAO<MedicalConsultation> implements GenericRepository<MedicalConsultation> {
	

	private static final long serialVersionUID = -2060061737182731614L;

	@Override
	protected Class<MedicalConsultation> getDomainClass() {
		return MedicalConsultation.class;
	}

}
