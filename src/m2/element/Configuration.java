package m2.element;

import java.util.ArrayList;
import java.util.List;

import m2.interfaces.Interface;
import m2.link.Link;
import m2.option.Property;
import m2.option.TechnicalConstraint;


public class Configuration extends Component {
	
	private List<Property> properties;
	private List<TechnicalConstraint> constraints;
	private List<Link> links;
	private List<Interface> interfaces;
	private List<Element> elements;

	public Configuration(String name, Interface intfce) {
		super(name);
		this.interfaces=new ArrayList<Interface>();
		this.addInterface(intfce);
	}
	
	/*
	 * constraints
	 */
	
	public boolean containsProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.contains(property);			
		}
	}
	
	public boolean addProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.add(property);
		}
	}
	
	public boolean addProperties(List<Property> properties) {
		synchronized (this.properties) {
			return this.properties.addAll(properties);
		}
	}
	
	public boolean addProperties(Property... properties) {
		boolean added=true;
		synchronized (this.properties) {
			for(Property p:properties) {
				added&=this.properties.add(p);
			}
		}
		return added;
	}
	
	public boolean removeProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.remove(property);
		}
	}
	
	/*
	 * Constrainsts
	 */
	
	public boolean containsConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.contains(constraint);			
		}
	}
	
	public boolean addConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.add(constraint);
		}
	}
	
	public boolean addConstraints(List<TechnicalConstraint> constraints) {
		synchronized (this.constraints) {
			return this.constraints.addAll(constraints);
		}
	}
	
	public boolean addConstraints(TechnicalConstraint... constraints) {
		boolean added=true;
		synchronized (this.constraints) {
			for(TechnicalConstraint c:constraints) {
				added&=this.constraints.add(c);
			}
		}
		return added;
	}
	
	public boolean removeConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.remove(constraint);
		}
	}
	
	/*
	 * Links
	 */
	
	public boolean containsLink(Link link) {
		synchronized (this.links) {
			return this.links.contains(link);			
		}
	}
	
	public boolean addLink(Link link) {
		synchronized (this.links) {
			return this.links.add(link);
		}
	}
	
	public boolean addLinks(List<Link> links) {
		synchronized (this.links) {
			return this.links.addAll(links);
		}
	}
	
	public boolean addLinks(Link... links) {
		boolean added=true;
		synchronized (this.links) {
			for(Link l:links) {
				added&=this.links.add(l);
			}
		}
		return added;
	}
	
	public boolean removeLink(Link link) {
		synchronized (this.links) {
			return this.links.remove(link);
		}
	}
	
	/*
	 * Interfaces
	 */
	
	public boolean containsInterface(Interface intfce) {
		synchronized (this.interfaces) {
			return this.interfaces.contains(intfce);			
		}
	}
	
	public boolean addInterface(Interface intfce) {
		synchronized (this.interfaces) {
			return this.interfaces.add(intfce);
		}
	}
	
	public boolean addInterfaces(List<Interface> interfaces) {
		synchronized (this.interfaces) {
			return this.interfaces.addAll(interfaces);
		}
	}
	
	public boolean addInterfaces(Interface... interfaces) {
		boolean added=true;
		synchronized (this.interfaces) {
			for(Interface l:interfaces) {
				added&=this.interfaces.add(l);
			}
		}
		return added;
	}
	
	public boolean removeInterface(Interface intfce) {
		synchronized (this.interfaces) {
			return this.interfaces.remove(intfce);
		}
	}
	
	/*
	 * Elements
	 */
	
	public boolean containsElement(Element element) {
		synchronized (this.elements) {
			return this.elements.contains(element);			
		}
	}
	
	public boolean addElement(Element element) {
		synchronized (this.elements) {
			return this.elements.add(element);
		}
	}
	
	public boolean addElements(List<Element> elements) {
		synchronized (this.elements) {
			return this.elements.addAll(elements);
		}
	}
	
	public boolean addElements(Element... elements) {
		boolean added=true;
		synchronized (this.elements) {
			for(Element e:elements) {
				added&=this.elements.add(e);
			}
		}
		return added;
	}
	
	public boolean removeElement(Element element) {
		synchronized (this.elements) {
			return this.elements.remove(element);
		}
	}
	
}
