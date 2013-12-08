package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class AuthRequiredPort extends Port {

	public AuthRequiredPort(int numPort) {
		super("AuthRequiredPort", InterfaceType.REQUIRED, numPort);
	}

}
