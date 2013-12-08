package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class SecTo extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1845716123717491847L;

	public SecTo() {
		super("SecTo", InterfaceType.REQUIRED);
	}

}
