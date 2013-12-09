package m2;

import java.io.Serializable;

/**
 * For each elements in our M2 model, we can assign a name, helping to identify
 * them.
 * 
 * @author Guillaume Coutable, Brian Gohier
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
	 * Return the object name
	 * 
	 * @return {@link String} - The object name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the object name
	 * 
	 * @param name
	 *            {@link String} - The object name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
