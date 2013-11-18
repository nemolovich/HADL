package m2.option;

import m2.M2Object;

public class Property extends M2Object {

	private Object value;

	public Property(String name, Object value) {
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
