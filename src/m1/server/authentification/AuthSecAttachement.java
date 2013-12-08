package m1.server.authentification;

import m1.server.security.SecTo;
import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class AuthSecAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 7337981683650679864L;

	public AuthSecAttachement(SecTo from, AuthProvidedPort to)
			throws NoDifferentsTypesException {
		super("AuthSecAttachement", from, to);
	}

}
