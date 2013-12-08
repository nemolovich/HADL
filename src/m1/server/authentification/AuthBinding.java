package m1.server.authentification;

import m1.server.configuration.AuthPort;
import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.link.Binding;

public class AuthBinding extends Binding {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -1116767445390450109L;

	// TODO: change type of attributes from and to
	public AuthBinding(String name, AuthPort from, AuthProvidedPort to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name, from, to);
	}

}
