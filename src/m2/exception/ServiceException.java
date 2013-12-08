package m2.exception;

public class ServiceException extends Exception {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4161140831965945136L;

	public ServiceException() {
	}

	@Override
	public void printStackTrace() {
		System.err.print("ServiceException: ");
	}

	protected void getInformations() {
		super.printStackTrace();
	}
}
