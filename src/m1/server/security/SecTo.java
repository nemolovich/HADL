package m1.server.security;

import m2.interfaces.InterfaceType;
import m2.interfaces.Role;

public class SecTo extends Role {

	public SecTo(String name) {
		super(name, InterfaceType.PROVIDED);
	}

}