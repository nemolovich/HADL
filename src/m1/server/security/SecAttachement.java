package m1.server.security;

import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class SecAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2532396915895092955L;

	public SecAttachement(String name, SecProvidedPort from, SecFrom to)
			throws NoDifferentsTypesException {
		super(name, from, to);
	}

}
