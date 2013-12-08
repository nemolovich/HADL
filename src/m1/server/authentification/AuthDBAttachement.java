package m1.server.authentification;

import m2.exception.NonDifferentsTypesException;
import m2.link.Attachement;

public class AuthDBAttachement extends Attachement {

	public AuthDBAttachement(AuthRequiredPort from, AuthFrom to)
			throws NonDifferentsTypesException {
		super("AuthDBAttachement", from, to);
	}

}
