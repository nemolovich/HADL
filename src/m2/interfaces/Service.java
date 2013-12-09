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

	/**
	 * Add a parameter in the parameters list
	 * 
	 * @param argName
	 *            {@link String} - The parameter name
	 * @param type
	 *            {@link Class Class<?>} - The expected type of this parameter
	 */
	public void addParameter(String argName, Class<?> type) {
		synchronized (this.args) {
			this.args.put(argName, type);
		}
	}

	/**
	 * Set the type of return object, and cast to this type when return service
	 * 
	 * @param returnType
	 */
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	/**
	 * Display the call description of the service
	 * 
	 * @param args
	 *            {@link Map}<{@link String},{@link Object}> - The parameters
	 */
	public void describe(Map<String, Object> args) {
		System.out.println("[Service{" + this.getName()
				+ "}] has been called with params "
				+ Arrays.toString(args.entrySet().toArray()));
	}

	/**
	 * Call the service and return its result and cast it in return type
	 * 
	 * @param args
	 *            {@link Map}<{@link String},{@link Object}> - The parameters
	 * @return {@link Object} - The service result
	 * @throws ServiceException
	 */
	public abstract Object call(Map<String, Object> args)
			throws ServiceException;

}
