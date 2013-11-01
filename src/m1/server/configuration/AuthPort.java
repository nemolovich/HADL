package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 *
 */
public class AuthPort extends Port {

	public AuthPort(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}
