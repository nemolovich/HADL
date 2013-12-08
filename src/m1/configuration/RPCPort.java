package m1.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class RPCPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 4285102881967215025L;

	public RPCPort(int numPort) {
		super("RPCPort", InterfaceType.REQUIRED, numPort);
	}

}
