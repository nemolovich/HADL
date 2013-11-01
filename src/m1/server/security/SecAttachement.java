package m1.server.security;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class SecAttachement extends Attachement {

	public SecAttachement(String name, SecProvidedPort from, SecFrom to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
