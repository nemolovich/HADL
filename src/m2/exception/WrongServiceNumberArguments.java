package m2.exception;

public class WrongServiceNumberArguments extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -6688339397045213417L;
	private int nbArgs;

	public WrongServiceNumberArguments(int nbArgs) {
		this.nbArgs = nbArgs;
	}

	@Override
	public void printStackTrace() {
		System.err.println("WrongServiceNumberArguments: "
				+ "This service required " + this.nbArgs + " parameters");
		super.printStackTrace();
	}
}
