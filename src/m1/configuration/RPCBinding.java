package m1.configuration;

import m1.server.RPCServeurPort;
import m1.server.configuration.RPCConfPort;
import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;
import m2.link.Binding;

public class RPCBinding extends Binding {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2411575011504987646L;

	public RPCBinding(RPCConfPort from, RPCServeurPort to)
			throws NoRequiredTypeFrom, NoProvidedTypeTo {
		super("RPCBinding", from, to);
	}

}
