package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class DBFrom extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1893007289676567329L;

	public DBFrom() {
		super("DBFrom", InterfaceType.PROVIDED);
	}

}
