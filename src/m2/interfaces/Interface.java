package m2.interfaces;

import m2.M2Object;
import m2.element.Configuration;

public abstract class Interface extends M2Object {
	private InterfaceType type;
	protected Configuration configuration;

	public Interface(String name, InterfaceType type) {
		super(name);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public InterfaceType getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(InterfaceType type) {
		this.type = type;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
}
