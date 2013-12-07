package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class AuthProvidedPort extends Port {

	public AuthProvidedPort(String name, int numPort) {
		super(name, InterfaceType.PROVIDED, numPort);
	}

}
