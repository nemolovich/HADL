package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBPort extends Port {

	public DBPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
