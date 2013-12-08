package m1.server.authentification;

import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class AuthAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -3822650923974240757L;

	public AuthAttachement(String name, AuthProvidedPort from, AuthFrom to)
			throws NoDifferentsTypesException {
		super(name, from, to);
	}

}
