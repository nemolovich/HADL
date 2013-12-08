package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class DBPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2459846848217108584L;

	public DBPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
