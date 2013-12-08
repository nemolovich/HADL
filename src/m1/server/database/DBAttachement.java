package m1.server.database;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5233253285553136864L;

	public DBAttachement(String name, DBProvidedPort from, DBFrom to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
