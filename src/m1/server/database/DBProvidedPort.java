package m1.server.database;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class DBProvidedPort extends Port {

	public DBProvidedPort(String name) {
		super(name, InterfaceType.PROVIDED);
	}

}