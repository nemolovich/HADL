package m1.configuration;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class RPCPort extends Port {

	public RPCPort(String name, int numPort) {
		super(name, InterfaceType.REQUIRED, numPort);
	}

}
