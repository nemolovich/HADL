package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class AuthRequiredPort extends Port {

	public AuthRequiredPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
