package m1.server.security;

import m2.connector.Glue;
import m2.exception.NonDifferentsTypesException;

public class SecGlue extends Glue {

	public SecGlue(String name, SecFrom from, SecTo to)
			throws NonDifferentsTypesException {
		super(name, from, to);
	}

}
