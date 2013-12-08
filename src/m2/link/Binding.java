package m2.link;

import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;
import m2.interfaces.Interface;
import m2.interfaces.InterfaceType;

public abstract class Binding extends Link {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 4544666909164188962L;

	public Binding(String name, Interface from, Interface to)
			throws NoRequiredTypeFrom, NoProvidedTypeTo {
		super(name);
		if (!from.getType().equals(InterfaceType.REQUIRED)) {
			throw new NoRequiredTypeFrom();
		}
		if (!to.getType().equals(InterfaceType.PROVIDED)) {
			throw new NoProvidedTypeTo();
		}
		super.setFrom(from);
		super.setTo(to);
	}

}
