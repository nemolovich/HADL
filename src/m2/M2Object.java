package m2;
/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * Permet l'extraction de l'attribut 'name' de chaque classe de notre modele M2
 *
 */
public abstract class M2Object {
	
	private String name;

	public M2Object(String name) {
		this.name=name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
