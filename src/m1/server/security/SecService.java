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

public class SecService extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3822143665699092214L;

	public SecService() {
		super("SecService", InterfaceType.PROVIDED);
		this.addParameter("user", String.class);
		this.addParameter("password", String.class);
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
		params.put("user", args.get("user"));
		params.put("password", args.get("password"));
		System.out.println("[Service{" + this.getName() + "}] Call service {"
				+ "AuthService" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		String password = (String) this.component.callService("AuthService",
				params);
		if (password == null) {
			return false;
		}
		return (password.equals(args.get("password")));
	}

}
