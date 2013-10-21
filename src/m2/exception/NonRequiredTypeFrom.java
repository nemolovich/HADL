package m2.exception;

public class NonRequiredTypeFrom extends BindingException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5211345776314237296L;
	
	public NonRequiredTypeFrom() {
		super();
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("The from type must be REQUIRED");
		super.getInformations();
	}

}
