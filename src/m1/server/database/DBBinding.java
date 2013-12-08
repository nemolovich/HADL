package m1.server.database;

import m1.server.configuration.DBPort;
import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;
import m2.link.Binding;

public class DBBinding extends Binding {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -5203226521199223266L;

	// TODO: change type of attributes from and to
	public DBBinding(String name, DBPort from, DBProvidedPort to)
			throws NoRequiredTypeFrom, NoProvidedTypeTo {
		super(name, from, to);
	}

}
