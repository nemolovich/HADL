package m2.exception;

public class WrongServiceArgumentType extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3834752471863053303L;
	private Class<?> type;
	private String name;

	public WrongServiceArgumentType(String name, Class<?> type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public void printStackTrace() {
		System.err.println("WrongServiceArgumentType: Argument \"" + this.name
				+ "\" expect type \"" + this.type.getName() + "\"");
		super.printStackTrace();
	}
}
