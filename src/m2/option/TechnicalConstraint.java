package m2.option;

import m2.M2Object;

public class TechnicalConstraint extends M2Object {

	private Object value;
	
	public TechnicalConstraint(String name, Object value) {
		super(name);
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
