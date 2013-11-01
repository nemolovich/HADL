package m1.server.database;

import m1.server.security.SecProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBSecAttachement extends Attachement {

	public DBSecAttachement(String name, DBRequiredPort from, SecProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
