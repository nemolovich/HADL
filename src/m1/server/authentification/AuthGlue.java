package m1.server.authentification;

import m2.connector.Glue;
import m2.exception.NoDifferentsTypesException;

public class AuthGlue extends Glue {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -4772873788508288655L;

	public AuthGlue(AuthFrom from, AuthTo to)
			throws NoDifferentsTypesException {
		super("AuthGlue", from, to);
	}

}
