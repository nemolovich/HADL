package m1.configuration;

import m1.server.configuration.RPCConfPort;
import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class RPCAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 7319003102747332135L;

	public RPCAttachement(RPCConfPort from, RPCFrom to)
			throws NoDifferentsTypesException {
		super("RPCAttachement", from, to);
	}

}
