package m2.exception;

public class ServiceException extends Exception {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4161140831965945136L;
	private String serviceName;

	public ServiceException(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public void printStackTrace() {
		System.err.println("ServiceException: {" + this.serviceName + "}:");
	}

	protected void getInformations() {
		super.printStackTrace();
	}
}
