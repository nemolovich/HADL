package m1.server.authentification;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class AuthSecAttachement extends Attachement {

	public AuthSecAttachement(String name, Interface from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
