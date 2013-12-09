package m1.server.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import m2.exception.ServiceException;
import m2.exception.WrongServiceArgumentType;
import m2.exception.WrongServiceArguments;
import m2.exception.WrongServiceNumberArguments;
import m2.interfaces.InterfaceType;
import m2.interfaces.Service;

/**
 * 
 * @param user
 *            {@link String String.class} - The user name
 * @param password
 *            {@link String String.class} - The user password
 * @return {@link Boolean boolean.class} - <code>true</code> if the parameters
 *         make match user and password, <code>false</code> otherwise
 * @author Guillaume COUTABLE, Brian GOHIER
 * @see {@link Service}
 */
public class SecService extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3822143665699092214L;

	public SecService() {
		super("SecService", InterfaceType.PROVIDED);
		this.addParameter("user", String.class);
		this.setReturnType(String.class);
	}

	@Override
	public Object call(Map<String, Object> args) throws ServiceException {
		this.describe(args);
		if (args.size() != this.args.size()) {
			throw new WrongServiceNumberArguments(this.getName(),
					this.args.size());
		}
		synchronized (this.args) {
			for (String param : this.args.keySet()) {
				if (!args.containsKey(param)) {
					throw new WrongServiceArguments(this.getName());
				} else if (!this.args.get(param).isAssignableFrom(
						args.get(param).getClass())) {
					throw new WrongServiceArgumentType(this.getName(), param,
							this.args.get(param));
				}
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", args.get("user"));
		System.out.println("[Service{" + this.getName() + "}] Call service {"
				+ "DBServiceAuth" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		return this.returnType.cast(this.component.callService("DBServiceAuth",
				params));
	}

}
