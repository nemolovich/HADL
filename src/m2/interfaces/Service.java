package m2.interfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import m2.exception.ServiceException;

public abstract class Service extends Interface {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 6879147866222832457L;
	protected Map<String, Class<?>> args;
	protected Class<?> returnType;

	public Service(String name, InterfaceType type) {
		super(name, type);
		this.args = new HashMap<String, Class<?>>();
	}

	public void addParameter(String argName, Class<?> type) {
		synchronized (this.args) {
			this.args.put(argName, type);
		}
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public void describe(Map<String, Object> args) {
		System.out.println("[Service{" + this.getName()
				+ "}] has been called with params "
				+ Arrays.toString(args.entrySet().toArray()));
	}

	public abstract Object call(Map<String, Object> args)
			throws ServiceException;

}
