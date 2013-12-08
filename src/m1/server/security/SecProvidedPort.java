package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class SecProvidedPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2808272654387496307L;

	public SecProvidedPort(int numPort) {
		super("SecProvidedPort", InterfaceType.PROVIDED, numPort);
	}

}
