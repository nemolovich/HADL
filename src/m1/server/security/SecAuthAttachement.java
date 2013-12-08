package m1.server.security;

import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class SecAuthAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -5204978816416173266L;

	public SecAuthAttachement(SecRequiredPort from, SecFrom to)
			throws NoDifferentsTypesException {
		super("SecAuthAttachement", from, to);
	}

}
