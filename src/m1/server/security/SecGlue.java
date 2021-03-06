package m1.server.security;

import m2.connector.Glue;
import m2.exception.NoDifferentsTypesException;

public class SecGlue extends Glue {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2992935445291841594L;

	public SecGlue(SecFrom from, SecTo to) throws NoDifferentsTypesException {
		super("SecGlue", from, to);
	}

}
