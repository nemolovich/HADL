package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class SecRequiredPort extends Port {

	public SecRequiredPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
