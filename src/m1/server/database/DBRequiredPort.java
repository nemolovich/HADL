package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBRequiredPort extends Port {

	public DBRequiredPort(int numPort) {
		super("DBRequiredPort", InterfaceType.REQUIRED, numPort);
	}

}
