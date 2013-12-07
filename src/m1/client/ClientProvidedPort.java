package m1.client;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class ClientProvidedPort extends Port {

	public ClientProvidedPort(String name, int numPort) {
		super(name, InterfaceType.PROVIDED, numPort);
	}
}
