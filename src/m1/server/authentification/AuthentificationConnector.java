package m1.server.authentification;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class AuthentificationConnector extends AtomicConnector {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 7554934654074295340L;

	public AuthentificationConnector(List<Role> roles, List<Glue> glues) {
		super("AuthentificationConnector", roles, glues);
	}

	public AuthentificationConnector() {
		super("AuthentificationConnector");
	}

}
