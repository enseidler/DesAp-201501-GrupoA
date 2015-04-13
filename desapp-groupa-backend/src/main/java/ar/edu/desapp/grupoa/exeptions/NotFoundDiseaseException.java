package ar.edu.desapp.grupoa.exeptions;

public class NotFoundDiseaseException extends RuntimeException {

	public NotFoundDiseaseException() {
		super("There is no diagnosis in the database for current symptoms.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



}
