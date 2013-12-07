package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class SecProvidedPort extends Port {

	public SecProvidedPort(String name, int numPort) {
		super(name, InterfaceType.PROVIDED, numPort);
	}

}
