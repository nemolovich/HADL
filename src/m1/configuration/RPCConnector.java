package m1.configuration;

import java.util.List;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.interfaces.Role;

public class RPCConnector extends AtomicConnector {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 8555718792635210235L;

	public RPCConnector(String name, List<Role> roles, List<Glue> glues) {
		super(name, roles, glues);
		// TODO Auto-generated constructor stub
	}

	public RPCConnector(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
