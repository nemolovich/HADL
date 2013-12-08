package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class SecFrom extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -8066500769651113302L;

	public SecFrom() {
		super("SecFrom", InterfaceType.PROVIDED);
	}

}
