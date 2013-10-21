package m2.exception;

public class NonDifferentsTypesException extends Exception {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2888550584884551879L;
	
	public NonDifferentsTypesException() {
	}
	
	@Override
	public void printStackTrace() {
		System.err.println("NonDifferentsTypesException: The from interface " +
				"and the to interface must be different");
		super.printStackTrace();
	}

}
