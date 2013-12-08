package m1.server.database;

import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class DBSecAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 6643273418515884806L;

	public DBSecAttachement(DBRequiredPort from, DBFrom to)
			throws NoDifferentsTypesException {
		super("DBSecAttachement", from, to);
	}

}
