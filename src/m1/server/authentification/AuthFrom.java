package m1.server.authentification;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class AuthFrom extends Role {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2058820217216787047L;

	public AuthFrom() {
		super("AuthFrom", InterfaceType.PROVIDED);
	}

}
