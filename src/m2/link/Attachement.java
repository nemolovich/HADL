package m2.link;

import m2.exception.NoDifferentsTypesException;
import m2.interfaces.Interface;

public abstract class Attachement extends Link {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -1443154482260170351L;

	public Attachement(String name, Interface from, Interface to)
			throws NoDifferentsTypesException {
		super(name);
		if (from.getType().equals(to.getType())) {
			throw new NoDifferentsTypesException();
		}
		super.setFrom(from);
		super.setTo(to);
	}

}
