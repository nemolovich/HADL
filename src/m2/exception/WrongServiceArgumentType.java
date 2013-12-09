package m2.exception;

public class WrongServiceArgumentType extends ServiceException {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3834752471863053303L;
	private Class<?> type;
	private String attName;

	public WrongServiceArgumentType(String serviceName, String attName,
			Class<?> type) {
		super(serviceName);
		this.attName = attName;
		this.type = type;
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("WrongServiceArgumentType: Argument \""
				+ this.attName + "\" expect type \"" + this.type.getName()
				+ "\"");
	}
}
