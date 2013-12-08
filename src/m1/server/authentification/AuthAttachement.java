package m1.server.authentification;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class AuthAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -3822650923974240757L;

	public AuthAttachement(String name, AuthProvidedPort from, AuthFrom to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
