package m1.server;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class RPCServeurPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -472805692514703021L;

	public RPCServeurPort(int port) {
		super("RPCServeurPort", InterfaceType.PROVIDED, port);
	}

}
