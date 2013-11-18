package m2.connector;

import java.util.ArrayList;
import java.util.List;

import m2.element.Element;
import m2.interfaces.Role;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 * 
 */
public abstract class AtomicConnector extends Element {

	private List<Role> roles;
	private List<Glue> glues;

	public AtomicConnector(String name, List<Role> roles, List<Glue> glues) {
		super(name);
		this.roles = roles;
		this.glues = glues;
	}

	public AtomicConnector(String name) {
		this(name, new ArrayList<Role>(), new ArrayList<Glue>());
	}

	/**
	 * Add a role
	 * 
	 * @param role
	 *            to add
	 * @return {@code true} if the role had been added
	 */
	public boolean addRole(Role role) {
		synchronized (this.roles) {
			return this.roles.add(role);
		}
	}

	/**
	 * Add a list of roles
	 * 
	 * @param roles
	 *            to add
	 * @return {@code true} if roles had all been added
	 */
	public boolean addRoles(List<Role> roles) {
		synchronized (this.roles) {
			return this.roles.addAll(roles);
		}
	}

	/**
	 * Add roles
	 * 
	 * @param roles
	 *            to add
	 * @return {@code true} if roles had all been added
	 */
	public boolean addRoles(Role... roles) {
		boolean b = true;
		synchronized (this.roles) {
			for (Role r : roles) {
				b &= this.roles.add(r);
			}
		}
		return b;
	}

	/**
	 * Add glue
	 * 
	 * @param glue
	 *            to add
	 * @return {@code true} if the glue had been added
	 */
	public boolean addGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.add(glue);
		}
	}

	/**
	 * Add a list of glues
	 * 
	 * @param glues
	 *            to add
	 * @return {@code true} if glues had all been added
	 */
	public boolean addGlues(List<Glue> glues) {
		synchronized (this.glues) {
			return this.glues.addAll(glues);
		}
	}

	/**
	 * Add glues
	 * 
	 * @param glues
	 *            to add
	 * @return {@code true} if glues had all been added
	 */
	public boolean addGlues(Glue... glues) {
		boolean b = true;
		synchronized (this.glues) {
			for (Glue r : glues) {
				b &= this.glues.add(r);
			}
		}
		return b;
	}

	/**
	 * remove the role from the connector
	 * 
	 * @param role
	 *            to remove
	 * @return {@code true} if this connector contained the specified role
	 */
	public boolean removeRole(Role role) {
		synchronized (this.roles) {
			return this.roles.remove(role);
		}
	}

	/**
	 * remove the glue from this connector
	 * 
	 * @param glue
	 *            to remove
	 * @return {@code true} if this connector contained the specified glue
	 */
	public boolean removeGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.remove(glue);
		}
	}

	/**
	 * Check if this connector contains the specified role
	 * 
	 * @param role
	 *            whose presence in this connector is to be tested
	 * @return {@code true} if this connector contain the specified role
	 */
	public boolean containRole(Role role) {
		synchronized (this.roles) {
			return this.roles.contains(role);
		}
	}

	/**
	 * Check if this connector contains the specified glue
	 * 
	 * @param glue
	 *            whose presence in this connector is to be tested
	 * @return {@code true} if this connector contain the specified glue
	 */
	public boolean containGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.contains(glue);
		}
	}
}
