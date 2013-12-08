package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class AuthPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -9186142971367299064L;

	public AuthPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
