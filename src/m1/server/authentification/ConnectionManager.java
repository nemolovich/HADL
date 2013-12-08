package m1.server.authentification;

import m2.element.Component;

public class ConnectionManager extends Component {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -7903324595112837244L;

	public ConnectionManager(AuthProvidedPort port) {
		super("ConnectionManager", port);
	}

}
