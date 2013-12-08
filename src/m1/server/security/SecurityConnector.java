package m1.server.security;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class SecurityConnector extends AtomicConnector {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 7476460606842394754L;

	public SecurityConnector(List<Role> roles, List<Glue> glues) {
		super("SecurityConnector", roles, glues);
	}

	public SecurityConnector() {
		super("SecurityConnector");
	}

}
