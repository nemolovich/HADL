package m1.server.authentification;

import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class AuthDBAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2740083052862062052L;

	public AuthDBAttachement(AuthRequiredPort from, AuthFrom to)
			throws NoDifferentsTypesException {
		super("AuthDBAttachement", from, to);
	}

}
