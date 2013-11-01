package m1.server.database;

import m2.connector.Glue;
import m2.exception.NonDifferentsTypesException;

public class DBGlue extends Glue {

	public DBGlue(String name, DBFrom from, DBTo to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
