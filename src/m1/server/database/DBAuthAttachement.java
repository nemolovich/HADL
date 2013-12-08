package m1.server.database;

import m1.server.authentification.AuthTo;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBAuthAttachement extends Attachement {

	public DBAuthAttachement(AuthTo from, DBProvidedPort to)
			throws NonDifferentsTypesException {
		super("DBAuthAttachement", from, to);
	}

}
