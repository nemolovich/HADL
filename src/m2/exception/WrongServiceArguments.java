package m2.exception;

public class WrongServiceArguments extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -6688339397045213417L;

	public WrongServiceArguments() {
	}

	@Override
	public void printStackTrace() {
		System.err.println("WrongServiceArguments: The given parameters are "
				+ "incorrects for this servcie");
		super.printStackTrace();
	}
}
