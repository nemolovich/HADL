package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class RPCConfPort extends Port {

	public RPCConfPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
