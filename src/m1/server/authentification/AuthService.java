package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Service;

public class AuthService extends Service {

	public AuthService() {
		super("Authentication service", InterfaceType.PROVIDED);
	}

}
