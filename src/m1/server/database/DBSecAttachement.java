package m1.server.database;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;
import m2.link.Attachement;

public class DBSecAttachement extends Attachement {

	public DBSecAttachement(String name, DBRequiredPort from, Interface to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
