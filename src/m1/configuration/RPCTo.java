package m1.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class RPCTo extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -798152003252946967L;

	public RPCTo() {
		super("RPCTo", InterfaceType.REQUIRED);
	}

}
