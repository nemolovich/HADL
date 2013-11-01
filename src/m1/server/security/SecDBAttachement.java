package m1.server.security;

import m1.server.database.DBProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class SecDBAttachement extends Attachement {

	public SecDBAttachement(String name, SecRequiredPort from, DBProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
