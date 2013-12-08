package m1.server.database;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBSecAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 6643273418515884806L;

	public DBSecAttachement(DBRequiredPort from, DBFrom to)
			throws NonDifferentsTypesException {
		super("DBSecAttachement", from, to);
	}

}
