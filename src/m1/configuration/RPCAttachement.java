package m1.configuration;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class RPCAttachement extends Attachement {

	public RPCAttachement(String name, RPCPort from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}