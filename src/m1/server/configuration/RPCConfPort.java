package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class RPCConfPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -7743429607010173678L;

	public RPCConfPort(int numPort) {
		super("RPCConfPort", InterfaceType.REQUIRED, numPort);
	}

}
