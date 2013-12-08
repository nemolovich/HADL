package m2.option;

import m2.M2Object;

public class TechnicalConstraint extends M2Object {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -932708622666998787L;
	private Object value;

	public TechnicalConstraint(String name, Object value) {
		super(name);
		this.value = value;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
