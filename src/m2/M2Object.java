package m2;

import java.io.Serializable;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 *         Permet l'extraction de l'attribut 'name' de chaque classe de notre
 *         modele M2
 * 
 */
public abstract class M2Object implements Serializable {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 801688483389088629L;
	private String name;

	public M2Object(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
