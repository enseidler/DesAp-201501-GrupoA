package ar.edu.desapp.grupoa.exceptions;

public class RecordExistException extends RuntimeException {
	
	public RecordExistException() {
		super("Already exist a medical record for this patient.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
