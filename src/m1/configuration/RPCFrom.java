package m1.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class RPCFrom extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 3919990392922194824L;

	public RPCFrom() {
		super("RPCFrom", InterfaceType.PROVIDED);
	}

}
