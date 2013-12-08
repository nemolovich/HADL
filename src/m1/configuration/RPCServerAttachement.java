package m1.configuration;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class RPCServerAttachement extends Attachement {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 2367785003488215662L;

	public RPCServerAttachement(String name, Interface from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
