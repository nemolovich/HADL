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

	public AuthService() {
		super("AuthenticationService", InterfaceType.PROVIDED);
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
				} else if (!args.get(param).getClass()
						.isAssignableFrom(this.args.get(param))) {
					throw new WrongServiceArgumentType(param,
							this.args.get(param));
				}
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("TABLE", "user");
		params.put("GET_COLUMN", "name");
		params.put("VALUE", args.get("user"));
		params.put("RETURN_COLUMN", "password");
		System.out.println("[Service{" + this.getName() + "}] Call service {"
				+ "DBServiceRequest" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		String password = (String) this.configuration.callService(
				"DBServiceRequest", params);
		return (password.equals(args.get("password")));
	}
}
