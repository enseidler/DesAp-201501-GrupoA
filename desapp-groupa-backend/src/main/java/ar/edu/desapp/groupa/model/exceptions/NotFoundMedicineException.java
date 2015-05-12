package ar.edu.desapp.groupa.model.exceptions;

public class NotFoundMedicineException extends RuntimeException {

	public NotFoundMedicineException() {
		super("There is no medicine existent to current disease.");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
