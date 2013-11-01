package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class SecPort extends Port {

	public SecPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
