package m1.configuration;

import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.interfaces.Interface;
import m2.link.Binding;

public class RPCBinding extends Binding {

	public RPCBinding(String name, Interface from, Interface to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
