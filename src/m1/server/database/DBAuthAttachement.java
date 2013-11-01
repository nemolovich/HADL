package m1.server.database;

import m1.server.authentification.AuthProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class DBAuthAttachement extends Attachement {

	public DBAuthAttachement(String name, DBRequiredPort from, AuthProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}