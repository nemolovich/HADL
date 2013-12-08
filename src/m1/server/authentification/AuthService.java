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
			throw new WrongServiceNumberArguments(this.args.size());
		}
		synchronized (this.args) {
			for (String param : this.args.keySet()) {
				if (!args.containsKey(param)) {
					throw new WrongServiceArguments();
				} else if (!this.args.get(param).isAssignableFrom(
						args.get(param).getClass())) {
					throw new WrongServiceArgumentType(param,
							this.args.get(param));
				}
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", args.get("user"));
		params.put("password", args.get("password"));
		System.out.println("[Service{" + this.getName() + "}] Call service {"
				+ "DBServiceAuth" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		return this.component.callService("DBServiceAuth", params);
	}
}
