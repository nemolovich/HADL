package m2.connector;

import m2.M2Object;
import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Role;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public abstract class Glue extends M2Object {

	private Role from;
	private Role to;

	/**
	 * Construct a glue
	 * 
	 * @param name
	 *            the name of the glue
	 * @param from
	 *            the linked role which call this glue
	 * @param to
	 *            the linked role which be called by this glue
	 * @throws NonDifferentsTypesException
	 *             if from Role and to Role are the same
	 */
	public Glue(String name, Role from, Role to)
			throws NonDifferentsTypesException {
		super(name);
		if (from.getType().equals(to.getType())) {
			throw new NonDifferentsTypesException();
		}
		this.from = from;
		this.to = to;
	}

	/**
	 * @return the from role
	 */
	public Role getFrom() {
		return this.from;
	}

	/**
	 * @param from
	 *            the from role to set
	 */
	public void setFrom(Role from) {
		this.from = from;
	}

	/**
	 * @return the to role
	 */
	public Role getTo() {
		return this.to;
	}

	/**
	 * @param to
	 *            the to role to set
	 */
	public void setTo(Role to) {
		this.to = to;
	}

}
