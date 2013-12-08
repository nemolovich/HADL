package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class SecRequiredPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -5268119301874627864L;

	public SecRequiredPort(int numPort) {
		super("SecRequiredPort", InterfaceType.REQUIRED, numPort);
	}

}
