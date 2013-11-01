package m1.server.authentification;

import m2.connector.Glue;
import m2.exception.NonDifferentsTypesException;

public class AuthGlue extends Glue {

	public AuthGlue(String name, AuthFrom from, AuthTo to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
