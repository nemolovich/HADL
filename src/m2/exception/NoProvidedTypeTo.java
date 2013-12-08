package m2.exception;

public class NoProvidedTypeTo extends BindingException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5211345776314237296L;
	
	public NoProvidedTypeTo() {
		super();
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("The to type must be PROVIDED");
		super.getInformations();
	}

}
