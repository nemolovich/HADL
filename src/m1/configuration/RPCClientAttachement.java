package m1.configuration;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class RPCClientAttachement extends Attachement {

	public RPCClientAttachement(String name, Interface from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
		// TODO Auto-generated constructor stub
	}

}
