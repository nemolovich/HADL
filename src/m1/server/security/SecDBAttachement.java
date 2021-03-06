package m1.server.security;

import m1.server.database.DBTo;
import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class SecDBAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -6929294546613998427L;

	public SecDBAttachement(DBTo from, SecProvidedPort to)
			throws NoDifferentsTypesException {
		super("SecDBAttachement", from, to);
	}

}
