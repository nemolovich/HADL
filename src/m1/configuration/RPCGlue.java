package m1.configuration;

import m2.connector.Glue;
import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Role;

public class RPCGlue extends Glue {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2827562629378582820L;

	public RPCGlue(String name, Role from, Role to)
			throws NonDifferentsTypesException {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
