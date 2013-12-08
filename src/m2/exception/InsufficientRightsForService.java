package m2.exception;

public class InsufficientRightsForService extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4331091040215514275L;

	private String name;

	public InsufficientRightsForService(String name) {
		this.name = name;
	}

	@Override
	public void printStackTrace() {
		System.err.println("InsufficientRightsForService: You do not have"
				+ " permission to call service {" + this.name + "}");
		super.printStackTrace();
	}

}
