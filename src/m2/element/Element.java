package m2.element;

import m2.M2Object;

public abstract class Element extends M2Object {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1038622974071317324L;
	protected Configuration configuration;

	public Element(String name) {
		super(name);
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
