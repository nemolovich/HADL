package m1.server.security;

import m1.server.configuration.AuthPort;
import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;
import m2.link.Binding;

public class SecBinding extends Binding {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 8180147446432825904L;

	// TODO: change type of attributes from and to
	public SecBinding(String name, AuthPort from, SecProvidedPort to)
			throws NoRequiredTypeFrom, NoProvidedTypeTo {
		super(name, from, to);
	}

}
