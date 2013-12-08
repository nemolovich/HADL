package m1.server.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public class SecPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2115112574326645552L;

	public SecPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
