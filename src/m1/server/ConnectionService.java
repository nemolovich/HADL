package m1.server;

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
 * This service is a service provided by the global configuration to check if
 * the user who gave the parameters ("user" and "password") gave the corrects
 * arguments. It will send a request to the {@link ServeurConfiguration} to know
 * if the password given match with the user name given in the database.
 * 
 * @param user
 *            {@link String String.class} - The user name
 * @param password
 *            {@link String String.class} - The user password
 * @return {@link Boolean boolean.class} - <code>true</code> if the parameters
 *         make match user and password, <code>false</code> otherwise
 * 
 * @author Guillaume COUTABLE, Brian GOHIER
 * @see {@link Service}
 */
public class ConnectionService extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -919256997959114358L;

	public ConnectionService() {
		super("ConnectionService", InterfaceType.PROVIDED);
		this.addParameter("user", String.class);
		this.addParameter("password", String.class);
		this.setReturnType(Boolean.class);
	}

	@Override
	public Object call(Map<String, Object> params) throws ServiceException {
		this.describe(params);
		if (params.size() != this.args.size()) {
			throw new WrongServiceNumberArguments(this.getName(),
					this.args.size());
		}
		synchronized (this.args) {
			for (String param : this.args.keySet()) {
				if (!params.containsKey(param)) {
					throw new WrongServiceArguments(this.getName());
				} else if (!this.args.get(param).isAssignableFrom(
						params.get(param).getClass())) {
					throw new WrongServiceArgumentType(this.getName(), param,
							this.args.get(param));
				}
			}
		}
		if (this.component.hasService("AuthService")) {
			Map<String, Object> authParams = new HashMap<String, Object>();
			authParams.put("user", params.get("user"));
			authParams.put("password", params.get("password"));
			System.out.println("[Service{" + this.getName()
					+ "}] Call service {" + "AuthService" + "} with params "
					+ Arrays.toString(authParams.entrySet().toArray()));
			return this.returnType.cast(this.component.callService(
					"AuthService", authParams));
		} else {
			System.err.println("[Service{" + this.getName()
					+ "}] FATAL ERROR: The parent configuration"
					+ " does not have service {AuthService}");
			System.exit(0);
		}
		return false;
	}
}
