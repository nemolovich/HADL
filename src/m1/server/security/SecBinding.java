package m1.server.security;

import m1.server.configuration.AuthPort;
import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.link.Binding;

public class SecBinding extends Binding {

	//TODO: change type of attributes from and to
	public SecBinding(String name, AuthPort from, SecProvidedPort to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name, from, to);
	}

}
