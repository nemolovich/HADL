package m1.server.database;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class DatabaseConnector extends AtomicConnector {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -3743985868765486544L;

	public DatabaseConnector(List<Role> roles, List<Glue> glues) {
		super("DatabaseConnector", roles, glues);
	}

	public DatabaseConnector() {
		super("DatabaseConnector");
	}

}
