package m2.interfaces;

import m2.M2Object;

public abstract class Interface extends M2Object {
	private InterfaceType type;

	public Interface(String name, InterfaceType type) {
		super(name);
		this.type=type;
	}
	
	/**
	 * @return the type
	 */
	public InterfaceType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(InterfaceType type) {
		this.type = type;
	}
}
