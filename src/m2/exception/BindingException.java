package m2.exception;

public abstract class BindingException extends Exception {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -7654729483150240302L;
	
	public BindingException() {
	}
	
	@Override
	public void printStackTrace() {
		System.err.print("BindingException: ");
	}
	
	protected void getInformations() {
		super.printStackTrace();
	}

}
