package m2.exception;

public class InsufficientRightsForService extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4331091040215514275L;

	public InsufficientRightsForService(String serviceName) {
		super(serviceName);
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("InsufficientRightsForService: You do not have"
				+ " permission to call this service");
	}
}
