package m1.server.security;

import m2.element.Component;

public class SecurityManager extends Component {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -8994268271976854385L;

	public SecurityManager(SecProvidedPort port) {
		super("SecurityManager", port);
	}

}
