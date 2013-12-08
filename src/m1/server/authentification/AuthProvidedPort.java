package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class AuthProvidedPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2959917494571187473L;

	public AuthProvidedPort(int numPort) {
		super("AuthProvidedPort", InterfaceType.PROVIDED, numPort);
	}

}
