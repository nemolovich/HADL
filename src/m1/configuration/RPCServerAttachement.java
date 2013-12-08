package m1.configuration;

import m1.server.RPCServeurPort;
import m2.exception.NoDifferentsTypesException;
import m2.link.Attachement;

public class RPCServerAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2367785003488215662L;

	public RPCServerAttachement(RPCTo from, RPCServeurPort to)
			throws NoDifferentsTypesException {
		super("RPCServerAttachement", from, to);
	}

}
