package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class SecFrom extends Role {

	public SecFrom(String name) {
		super(name, InterfaceType.REQUIRED);
	}

}