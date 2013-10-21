package m2.link;

import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;

public class Attachement extends Link {

	public Attachement(String name, Interface from, Interface to)
			throws NonDifferentsTypesException {
		super(name);
		if(from.getType().equals(to.getType())) {
			throw new NonDifferentsTypesException();
		}
		super.setFrom(from);
		super.setTo(to);
	}

}
