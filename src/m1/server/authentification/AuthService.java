package m1.server.authentification;

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
 * This service will return the password that must check with the given user
 * name.
 * 
 * @param user
 *            {@link String String.class} - The user name
 * @return {@link String String.class} - The password for given user
 * 
 * @author Guillaume COUTABLE, Brian GOHIER
 * @see Service
 */
public class AuthService extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5842472905027699735L;

	public AuthService() {
		super("AuthService", InterfaceType.PROVIDED);
		this.addParameter("user", String.class);
		this.addParameter("password", String.class);
		this.setReturnType(boolean.class);
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
				} else if (!args.get(param).getClass()
						.isAssignableFrom(this.args.get(param))) {
					throw new WrongServiceArgumentType(this.getName(), param,
							this.args.get(param));
				}
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", args.get("user"));
		System.out.println("[Service{" + this.getName() + "}] Call service {"
				+ "SecService" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		String password = (String) this.component.callService("SecService",
				params);
		if (password == null) {
			return false;
		}
		return (password.equals(args.get("password")));
	}
}
