package m1.server.database.generator;

import java.util.HashMap;
import java.util.Map;

public class EntityClass {

	private String name;
	private String id;
	private Map<String, String> attributes=new HashMap<String, String>();
	private Map<String, String> constraints=new HashMap<String, String>();
	
	public EntityClass(String name) {
		this.name=name;
	}
	
	public boolean hasConstraint(String attr) {
		return this.getConstraint(attr)!=null;
	}
	
	public String getConstraint(String attr) {
		return this.constraints.get(attr);
	}
	
	public boolean addAttribute(String attName, String attType) {
		String name=attName;
		String type=attType;
		if(name.charAt(0)=='*'&&name.length()>1) {
			name=name.substring(1);
			this.id=name;
		}
		if(type.contains(" IN")&&type.contains("(")&&
				type.contains(")")) {
			int index=type.indexOf(" IN");
			String checks=type.substring(type.indexOf("(", index),
					type.lastIndexOf(")")+1)+")";
			type=type.substring(0,index);
			while(type.endsWith(" ")) {
				type=type.substring(0,type.lastIndexOf(" "));
			}
			String constraint="NOT NULL \nCONSTRAINT "+name.toLowerCase()+
					"_ck CHECK ("+name.toLowerCase()+" IN "+checks;
			this.constraints.put(type, constraint);
		}
		else if(type.equalsIgnoreCase("BOOLEAN")) {
			String constraint="NOT NULL DEFAULT FALSE";
			this.constraints.put(type, constraint);
		}
		return this.attributes.put(name, type)==null;
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

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
