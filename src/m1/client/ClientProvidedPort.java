package m1.client;

import m2.interfaces.InterfaceType;
import m2.interfaces.Port;

public class ClientProvidedPort extends Port {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -846565431114505586L;

	public ClientProvidedPort(int numPort) {
		super("ClientProvidedPort", InterfaceType.PROVIDED, numPort);
	}
}
