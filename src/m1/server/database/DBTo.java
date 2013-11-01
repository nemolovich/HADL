package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class DBTo extends Role {

	public DBTo(String name) {
		super(name, InterfaceType.PROVIDED);
	}

}
