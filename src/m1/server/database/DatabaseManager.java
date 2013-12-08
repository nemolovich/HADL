package m1.server.database;

import m2.element.Component;

public class DatabaseManager extends Component {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4897206911154718446L;

	public DatabaseManager(DBProvidedPort port) {
		super("DatabaseManager", port);
	}
}
