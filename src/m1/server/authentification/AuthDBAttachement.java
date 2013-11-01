package m1.server.authentification;

import m1.server.database.DBProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class AuthDBAttachement extends Attachement {

	public AuthDBAttachement(String name, AuthRequiredPort from, DBProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
