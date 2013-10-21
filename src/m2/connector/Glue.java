package m2.connector;

import m2.M2Object;
import m2.interfaces.Role;

public class Glue extends M2Object {
	
	private Role from;
	private Role to;
	
	public Glue(String name, Role from, Role to) {
		super(name);
		this.from = from;
		this.to = to;
	}

	public Role getFrom() {
		return from;
	}

	public void setFrom(Role from) {
		this.from = from;
	}

	public Role getTo() {
		return to;
	}

	public void setTo(Role to) {
		this.to = to;
	}
	
}
