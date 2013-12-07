package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class DBPort extends Port {

	public DBPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
