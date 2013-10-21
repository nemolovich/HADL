package m2.link;

import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;
import m2.interfaces.Interface;
import m2.interfaces.InterfaceType;

public class Binding extends Link {

	public Binding(String name, Interface from, Interface to)
			throws NonRequiredTypeFrom, NonProvidedTypeTo {
		super(name);
		if(!from.getType().equals(InterfaceType.REQUIRED)) {
			throw new NonRequiredTypeFrom();
		}
		if(!to.getType().equals(InterfaceType.PROVIDED)) {
			throw new NonProvidedTypeTo();
		}
		super.setFrom(from);
		super.setTo(to);
	}

}
