package m1.server.security;

import m1.server.authentification.AuthProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class SecAuthAttachement extends Attachement {

	public SecAuthAttachement(String name, SecRequiredPort from, AuthProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
