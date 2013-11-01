package m1.server.authentification;

import m1.server.security.SecProvidedPort;
import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class AuthSecAttachement extends Attachement {

	public AuthSecAttachement(String name, AuthRequiredPort from, SecProvidedPort to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
