package m1.server.database;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBAttachement extends Attachement {

	public DBAttachement(String name, DBProvidedPort from, DBFrom to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
