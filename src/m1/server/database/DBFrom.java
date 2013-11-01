package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class DBFrom extends Role {

	public DBFrom(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
