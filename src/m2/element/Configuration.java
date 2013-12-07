package m2.element;

import java.util.List;

import m2.M2Object;
import m2.interfaces.Interface;
import m2.link.Attachement;
import m2.link.Link;
import m2.option.Property;
import m2.option.TechnicalConstraint;

/**
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public abstract class Configuration extends Component {

	private List<Property> properties;
	private List<TechnicalConstraint> constraints;
	private List<Element> elements;

	public Configuration(String name, Interface intfce) {
		super(name, intfce);
	}

	/*
	 * properties
	 */

	/**
	 * Check if this configuration contains the specified property
	 * 
	 * @param property
	 *            whose presence in this configuration is to be tested
	 * @return {@code true} if this configuration contain the specified property
	 */
	public boolean containsProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.contains(property);
		}
	}

	/**
	 * Add property
	 * 
	 * @param property
	 *            to add
	 * @return {@code true} if the property had been added
	 */
	public boolean addProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.add(property);
		}
	}

	/**
	 * Add a list of properties
	 * 
	 * @param properties
	 *            to add
	 * @return {@code true} if properties had all been added
	 */
	public boolean addProperties(List<Property> properties) {
		synchronized (this.properties) {
			return this.properties.addAll(properties);
		}
	}

	/**
	 * Add properties
	 * 
	 * @param properties
	 *            to add
	 * @return {@code true} if properties had all been added
	 */
	public boolean addProperties(Property... properties) {
		boolean added = true;
		synchronized (this.properties) {
			for (Property p : properties) {
				added &= this.properties.add(p);
			}
		}
		return added;
	}

	/**
	 * remove the property from this configuration
	 * 
	 * @param property
	 *            to remove
	 * @return {@code true} if this configuration contained the specified
	 *         property
	 */
	public boolean removeProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.remove(property);
		}
	}

	/*
	 * Constrainsts
	 */

	/**
	 * Check if this configuration contains the specified constraint
	 * 
	 * @param constraint
	 *            whose presence in this configuration is to be tested
	 * @return {@code true} if this configuration contain the specified
	 *         constraint
	 */
	public boolean containsConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.contains(constraint);
		}
	}

	/**
	 * Add constraint
	 * 
	 * @param constraint
	 *            to add
	 * @return {@code true} if the constraint had been added
	 */
	public boolean addConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.add(constraint);
		}
	}

	/**
	 * Add a list of constraints
	 * 
	 * @param constraints
	 *            to add
	 * @return {@code true} if constraints had all been added
	 */
	public boolean addConstraints(List<TechnicalConstraint> constraints) {
		synchronized (this.constraints) {
			return this.constraints.addAll(constraints);
		}
	}

	/**
	 * Add constraints
	 * 
	 * @param constraints
	 *            to add
	 * @return {@code true} if constraints had all been added
	 */
	public boolean addConstraints(TechnicalConstraint... constraints) {
		boolean added = true;
		synchronized (this.constraints) {
			for (TechnicalConstraint c : constraints) {
				added &= this.constraints.add(c);
			}
		}
		return added;
	}

	/**
	 * remove the constraint from this configuration
	 * 
	 * @param constraint
	 *            to remove
	 * @return {@code true} if this configuration contained the specified
	 *         constraint
	 */
	public boolean removeConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.remove(constraint);
		}
	}

	/*
	 * Elements
	 */

	/**
	 * Check if this configuration contains the specified element
	 * 
	 * @param element
	 *            whose presence in this configuration is to be tested
	 * @return {@code true} if this configuration contain the specified element
	 */
	public boolean containsElement(Element element) {
		synchronized (this.elements) {
			return this.elements.contains(element);
		}
	}

	/**
	 * Add element
	 * 
	 * @param element
	 *            to add
	 * @return {@code true} if the element had been added
	 */
	public boolean addElement(Element element) {
		synchronized (this.elements) {
			element.setConfiguration(this);
			return this.elements.add(element);
		}
	}

	/**
	 * Add a list of elements
	 * 
	 * @param elements
	 *            to add
	 * @return {@code true} if elements had all been added
	 */
	public boolean addElements(List<Element> elements) {
		synchronized (this.elements) {
			return this.elements.addAll(elements);
		}
	}

	/**
	 * Add elements
	 * 
	 * @param elements
	 *            to add
	 * @return {@code true} if elements had all been added
	 */
	public boolean addElements(Element... elements) {
		boolean added = true;
		synchronized (this.elements) {
			for (Element e : elements) {
				added &= this.elements.add(e);
			}
		}
		return added;
	}

	/**
	 * remove the element from this configuration
	 * 
	 * @param element
	 *            to remove
	 * @return {@code true} if this configuration contained the specified
	 *         element
	 */
	public boolean removeElement(Element element) {
		synchronized (this.elements) {
			return this.elements.remove(element);
		}
	}

	public void sendMessage(M2Object message, Component component) {
		synchronized (this.links) {
			for (Link l : this.links) {
				if (l instanceof Attachement) {
					synchronized (component.interfaces) {
						if (component.interfaces.contains(((Attachement) l)
								.getFrom())) {
							System.out.println("I got the good one!!");
						}
					}
				}
			}
		}
	}
}
