package m1.configuration;

import m2.element.Configuration;

public class GlobalConfiguration extends Configuration {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5114287978857251405L;

	public GlobalConfiguration(String name, RPCPort intfce) {
		super(name, intfce);
	}
}
