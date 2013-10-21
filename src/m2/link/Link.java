package m2.link;

import m2.M2Object;
import m2.interfaces.Interface;

public abstract class Link extends M2Object {

	private Interface from;
	private Interface to;

	public Link(String name, Interface from, Interface to) {
		super(name);
		this.from=from;
		this.to=to;
	}

	/**
	 * @return the from
	 */
	public Interface getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Interface from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Interface getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Interface to) {
		this.to = to;
	}

}
