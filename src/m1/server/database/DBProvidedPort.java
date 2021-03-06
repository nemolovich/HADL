package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBProvidedPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3527967191653025872L;

	public DBProvidedPort(int numPort) {
		super("DBProvidedPort", InterfaceType.PROVIDED, numPort);
	}

}
