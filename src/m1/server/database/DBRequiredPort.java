package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBRequiredPort extends Port {

	public DBRequiredPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
