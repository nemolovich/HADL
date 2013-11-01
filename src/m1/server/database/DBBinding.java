package m1.server.database;

import m1.server.configuration.DBPort;
import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.link.Binding;

public class DBBinding extends Binding {

	//TODO: change type of attributes from and to
	public DBBinding(String name, DBPort from, DBProvidedPort to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name, from, to);
	}

}
