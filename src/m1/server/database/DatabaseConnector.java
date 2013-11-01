package m1.server.database;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class DatabaseConnector extends AtomicConnector {

	public DatabaseConnector(String name, List<Role> roles,
			List<Glue> glues) {
		super(name, roles, glues);
	}

	public DatabaseConnector(String name) {
		super(name);
	}

}
