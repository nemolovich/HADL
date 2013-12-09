package m2.exception;

public class WrongServiceArguments extends ServiceException {
	/**
	 * ID
	 */
	private static final long serialVersionUID = -6688339397045213417L;

	public WrongServiceArguments(String servcieName) {
		super(servcieName);
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("WrongServiceArguments: The given parameters are "
				+ "incorrects for this servcie");
	}
}
