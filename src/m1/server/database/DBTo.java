package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class DBTo extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 9206063229159944986L;

	public DBTo() {
		super("DBTo", InterfaceType.REQUIRED);
	}

}
