package m1.server;

import java.util.Map;

import m2.exception.ServiceException;
import m2.interfaces.InterfaceType;
import m2.interfaces.Service;

public class ConnectionService extends Service {

	public ConnectionService() {
		super("ConnectionService", InterfaceType.PROVIDED);
	}

	@Override
	public Object call(Map<String, Object> params) throws ServiceException {
		if (this.component.hasService("AuthenticationService")) {
			return this.component.callService("AuthenticationService", params);
		} else {
			System.err.println("[Service{" + this.getName()
					+ "}] FATAL ERROR: The parent configuration"
					+ " does not have service {AuthenticationService}");
			System.exit(0);
		}
		return false;
	}
}
