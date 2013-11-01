package m1.server.security;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class SecurityConnector extends AtomicConnector {

	public SecurityConnector(String name, List<Role> roles,
			List<Glue> glues) {
		super(name, roles, glues);
	}

	public SecurityConnector(String name) {
		super(name);
	}

}
