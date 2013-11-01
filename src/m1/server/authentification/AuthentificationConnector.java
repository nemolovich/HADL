package m1.server.authentification;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class AuthentificationConnector extends AtomicConnector {

	public AuthentificationConnector(String name, List<Role> roles,
			List<Glue> glues) {
		super(name, roles, glues);
	}

	public AuthentificationConnector(String name) {
		super(name);
	}

}
