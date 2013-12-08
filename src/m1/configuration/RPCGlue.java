package m1.configuration;

import m2.connector.Glue;
import m2.exception.NonDifferentsTypesException;

public class RPCGlue extends Glue {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -2827562629378582820L;

	public RPCGlue(RPCFrom from, RPCTo to) throws NonDifferentsTypesException {
		super("RPCGlue", from, to);
	}

}
