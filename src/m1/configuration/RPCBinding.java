package m1.configuration;

import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;
import m2.interfaces.Interface;
import m2.link.Binding;

public class RPCBinding extends Binding {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2411575011504987646L;

	public RPCBinding(String name, Interface from, Interface to)
			throws NoRequiredTypeFrom, NoProvidedTypeTo {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
