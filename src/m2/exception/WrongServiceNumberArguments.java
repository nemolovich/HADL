package m2.exception;

public class WrongServiceNumberArguments extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -6688339397045213417L;
	private int nbArgs;

	public WrongServiceNumberArguments(String serviceName, int nbArgs) {
		super(serviceName);
		this.nbArgs = nbArgs;
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("WrongServiceNumberArguments: "
				+ "This service require " + this.nbArgs + " parameter(s)");
	}
}
