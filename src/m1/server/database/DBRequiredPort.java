package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBRequiredPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3075408042957933834L;

	public DBRequiredPort(int numPort) {
		super("DBRequiredPort", InterfaceType.REQUIRED, numPort);
	}

}
