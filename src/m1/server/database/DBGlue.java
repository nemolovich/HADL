package m1.server.database;

import m2.connector.Glue;
import m2.exception.NoDifferentsTypesException;

public class DBGlue extends Glue {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2154274878073562356L;

	public DBGlue(DBFrom from, DBTo to) throws NoDifferentsTypesException {
		super("DBGlue", from, to);
	}

}
