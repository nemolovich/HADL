package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class AuthRequiredPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 4520021440713459340L;

	public AuthRequiredPort(int numPort) {
		super("AuthRequiredPort", InterfaceType.REQUIRED, numPort);
	}

}
