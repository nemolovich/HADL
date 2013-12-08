package m1.server;

import java.util.Arrays;
import java.util.Map;

import m2.exception.ServiceException;
import m2.interfaces.InterfaceType;
import m2.interfaces.Service;

public class ConnectionService extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -919256997959114358L;

	public ConnectionService() {
		super("ConnectionService", InterfaceType.PROVIDED);
	}

	@Override
	public Object call(Map<String, Object> params) throws ServiceException {
		if (this.component.hasService("AuthService")) {
			System.out.println("[Service{" + this.getName()
					+ "}] Call service {" + "AuthService" + "} with params "
					+ Arrays.toString(params.entrySet().toArray()));
			String password = (String) this.component.callService(
					"AuthService", params);
			if (password == null) {
				return false;
			}
			return (password.equals(params.get("password")));
		} else {
			System.err.println("[Service{" + this.getName()
					+ "}] FATAL ERROR: The parent configuration"
					+ " does not have service {AuthService}");
			System.exit(0);
		}
		return false;
	}
}
