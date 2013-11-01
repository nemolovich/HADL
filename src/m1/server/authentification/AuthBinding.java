package m1.server.authentification;

import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.interfaces.Interface;
import m2.link.Binding;

public class AuthBinding extends Binding {

	//TODO: change type of attributes from and to
	public AuthBinding(String name, Interface from, Interface to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name, from, to);
	}

}
