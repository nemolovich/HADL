package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class AuthTo extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 6746980025783535857L;

	public AuthTo() {
		super("AuthTo", InterfaceType.REQUIRED);
	}

}
