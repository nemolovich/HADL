package m1.configuration;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class RPCClientAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -1356445880849834574L;

	public RPCClientAttachement(String name, Interface from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
