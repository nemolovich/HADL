package m1.server.database;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class DBAuthAttachement extends Attachement {

	public DBAuthAttachement(String name, DBRequiredPort from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
