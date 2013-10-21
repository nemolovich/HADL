package m2.connector;

import java.util.ArrayList;
import java.util.List;

import m2.element.Element;
import m2.interfaces.Role;

public class AtomicConnector extends Element{
	
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
	
	public boolean containRole(Role role) {
		synchronized (this.roles) {
			return this.roles.contains(role);
		}
	}
	
	public boolean containGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.contains(glue);
		}
	}
	
	public boolean addRole(Role role) {
		synchronized (this.roles) {
			return this.roles.add(role);
		}
	}
	
	public boolean addRoles(List<Role> roles) {
		synchronized (this.roles) {
					return this.roles.addAll(roles);
		}
	}
	
	public boolean addRoles(Role... roles) {
		boolean b = true;
		synchronized (this.roles) {
			for(Role r : roles) {
				b &= this.roles.add(r);
			}
		}
		return b;
	}
	
	public boolean addGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.add(glue);
		}
	}
	
	public boolean addGlues(List<Glue> glues) {
		synchronized (this.glues) {
			return this.glues.addAll(glues);
		}
	}
	
	public boolean addGlues(Glue... glues) {
		boolean b = true;
		synchronized (this.glues) {
			for(Glue r : glues) {
				b &= this.glues.add(r);
			}
		}
		return b;
	}
	
	public boolean removeRole(Role role) {
		synchronized (this.roles) {
			return this.roles.remove(role);
		}
	}
	
	public boolean removeGlue(Glue glue) {
		synchronized (this.glues) {
			return this.glues.remove(glue);
		}
	}
}
