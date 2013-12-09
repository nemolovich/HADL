package m2.element;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import m2.connector.AtomicConnector;
import m2.connector.Glue;
import m2.exception.ServiceException;
import m2.interfaces.Interface;
import m2.interfaces.InterfaceType;
import m2.interfaces.Port;
import m2.interfaces.Role;
import m2.interfaces.Service;
import m2.link.Attachement;
import m2.link.Link;
import m2.option.Property;
import m2.option.TechnicalConstraint;

/**
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public abstract class Configuration extends Component {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 8477547801164504437L;
	private List<Property> properties;
	private List<TechnicalConstraint> constraints;
	private List<Element> elements;

	public Configuration(String name, Interface intfce) {
		super(name, intfce);
		this.elements = new ArrayList<Element>();
		this.constraints = new ArrayList<TechnicalConstraint>();
		this.properties = new ArrayList<Property>();
	}

	/*
	 * properties
	 */

	/**
	 * Check if this configuration contains the specified {@link Property
	 * property}
	 * 
	 * @param property
	 *            {@link Property} - The property whose presence in this
	 *            configuration is to be tested
	 * @return {@link Boolean boolean} <code>true</code> if this configuration
	 *         contain the specified property, <code>false</code> otherwise
	 */
	public boolean containsProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.contains(property);
		}
	}

	/**
	 * Add a {@link Property property} in the current configuration
	 * 
	 * @param property
	 *            {@link Property} - The property to add
	 * @return {@link Boolean boolean} <code>true</code> if the property has
	 *         been added in the configuration
	 */
	public boolean addProperty(Property property) {
		synchronized (this.properties) {
			return this.properties.add(property);
		}
	}

	/**
	 * Add {@link Property properties} in the current configuration
	 * 
	 * @param properties
	 *            {@link List}<{@link Property}> - The properties to add
	 * @return {@link Boolean boolean} <code>true</code> if all the properties
	 *         had been added in the configuration
	 */
	public boolean addProperties(List<Property> properties) {
		synchronized (this.properties) {
			return this.properties.addAll(properties);
		}
	}

	/**
	 * Add {@link Property properties} in the current configuration
	 * 
	 * @param properties
	 *            {@link Property}[] - The properties to add
	 * @return {@link Boolean boolean} <code>true</code> if all the properties
	 *         had been added in the configuration
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
	 * Remove a {@link Property property} from the current configuration
	 * 
	 * @param property
	 *            {@link Property} - The property to remove
	 * @return {@link Boolean boolean} <code>true</code> if the property has
	 *         been correctly removed from the configuration
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
	 * Check if this configuration contains the specified
	 * {@link TechnicalConstraint constraint}
	 * 
	 * @param constraint
	 *            {@link TechnicalConstraint} - The constraint whose presence in
	 *            this configuration is to be tested
	 * @return {@link Boolean boolean} <code>true</code> if this configuration
	 *         contain the specified constraint, <code>false</code> otherwise
	 */
	public boolean containsConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.contains(constraint);
		}
	}

	/**
	 * Add a {@link TechnicalConstraint constraint} in the current configuration
	 * 
	 * @param constraint
	 *            {@link TechnicalConstraint} - The constraint to add
	 * @return {@link Boolean boolean} <code>true</code> if the constraint has
	 *         been added in the configuration
	 */
	public boolean addConstraint(TechnicalConstraint constraint) {
		synchronized (this.constraints) {
			return this.constraints.add(constraint);
		}
	}

	/**
	 * Add {@link TechnicalConstraint constraints} in the current configuration
	 * 
	 * @param constraints
	 *            {@link List}<{@link TechnicalConstraint}> - The constraints to
	 *            add
	 * @return {@link Boolean boolean} <code>true</code> if all the constraints
	 *         had been added in the configuration
	 */
	public boolean addConstraints(List<TechnicalConstraint> constraints) {
		synchronized (this.constraints) {
			return this.constraints.addAll(constraints);
		}
	}

	/**
	 * Add {@link TechnicalConstraint constraints} in the current configuration
	 * 
	 * @param constraints
	 *            {@link List}<{@link TechnicalConstraint}> - The constraints to
	 *            add
	 * @return {@link Boolean boolean} <code>true</code> if all the constraints
	 *         had been added in the configuration
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
	 * Remove an {@link TechnicalConstraint constraint} from the current
	 * configuration
	 * 
	 * @param constraint
	 *            {@link TechnicalConstraint} - The constraint to remove
	 * @return {@link Boolean boolean} <code>true</code> if the constraint has
	 *         been correctly removed from the configuration
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
	 * Check if this configuration contains the specified {@link Element
	 * element}
	 * 
	 * @param element
	 *            {@link Element} - The element whose presence in this
	 *            configuration is to be tested
	 * @return {@link Boolean boolean} <code>true</code> if this configuration
	 *         contain the specified element, <code>false</code> otherwise
	 */
	public boolean containsElement(Element element) {
		synchronized (this.elements) {
			return this.elements.contains(element);
		}
	}

	/**
	 * Add an element like {@link Component} or {@link Configuration} in the
	 * current configuration
	 * 
	 * @param element
	 *            {@link Element} - The element to add
	 * @return {@link Boolean boolean} <code>true</code> if the element has been
	 *         added in the configuration
	 */
	public boolean addElement(Element element) {
		synchronized (this.elements) {
			element.setConfiguration(this);
			return this.elements.add(element);
		}
	}

	/**
	 * Add elements like {@link Component} or {@link Configuration} in the
	 * current configuration
	 * 
	 * @param elements
	 *            {@link List}<{@link Element}> - The elements to add
	 * @return {@link Boolean boolean} <code>true</code> if all the elements had
	 *         been added in the configuration
	 */
	public boolean addElements(List<Element> elements) {
		synchronized (this.elements) {
			synchronized (elements) {
				for (Element e : elements) {
					e.setConfiguration(this);
				}
			}
			return this.elements.addAll(elements);
		}
	}

	/**
	 * Add elements like {@link Component} or {@link Configuration} in the
	 * current configuration
	 * 
	 * @param elements
	 *            {@link Element}[] - The elements to add
	 * @return {@link Boolean boolean} <code>true</code> if all the elements had
	 *         been added in the configuration
	 */
	public boolean addElements(Element... elements) {
		boolean added = true;
		synchronized (this.elements) {
			for (Element e : elements) {
				e.setConfiguration(this);
				added &= this.elements.add(e);
			}
		}
		return added;
	}

	/**
	 * Remove an element like {@link Component} or {@link Configuration} from
	 * the current configuration
	 * 
	 * @param element
	 *            {@link Element} - The element to remove
	 * @return {@link Boolean boolean} <code>true</code> if the element has been
	 *         correctly removed from the configuration
	 */
	public boolean removeElement(Element element) {
		synchronized (this.elements) {
			return this.elements.remove(element);
		}
	}

	/**
	 * Check if this configuration contains the specified service with given
	 * service name
	 * 
	 * @param serviceName
	 *            {@link String} - Name of service to search
	 * @return {@link Boolean boolean} - <code>true</code> if the service
	 *         exists, <code>false</code> otherwise
	 */
	@Override
	public boolean hasService(String serviceName) {
		synchronized (this.interfaces) {
			if (super.hasService(serviceName)) {
				return true;
			}
			synchronized (this.elements) {
				for (Element e : this.elements) {
					if (e instanceof Component) {
						if (((Component) e).hasService(serviceName)) {
							return true;
						}
					} else if (e instanceof Configuration) {
						if (((Configuration) e).hasService(serviceName)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public Object callService(String serviceName, Map<String, Object> args) {
		Service toCall = null;
		synchronized (this.interfaces) {
			for (Interface i : this.interfaces) {
				if (i instanceof Service) {
					if (i.getName().equalsIgnoreCase(serviceName)) {
						toCall = (Service) i;
					}
				}
			}
		}
		if (toCall == null) {
			synchronized (this.elements) {
				for (Element e : this.elements) {
					if (e instanceof Configuration) {
						if (((Configuration) e).containsService(serviceName)) {
							Object result = this.callServiceToConfiguration(
									serviceName, args, (Configuration) e);
							return result;
						}
					} else if (e instanceof Component) {
						synchronized (((Component) e).interfaces) {
							for (Interface i : ((Component) e).interfaces) {
								if (i.getName().equalsIgnoreCase(serviceName)) {
									toCall = (Service) i;
								}
							}
						}
					}
				}
			}
		}
		if (toCall != null) {
			System.out.println("[Configuration{" + this.getName()
					+ "}] Call service {" + toCall.getName() + "}");
			try {
				Object result = toCall.call(args);
				if (result != null) {
					System.out.println("[Configuration{" + this.getName()
							+ "}] got service response from {" + serviceName
							+ "}");
				} else {
					System.err.println("[Configuration{" + this.getName()
							+ "}] can not get service response from {"
							+ serviceName + "}");
				}
				return result;
			} catch (ServiceException e) {
				e.printStackTrace();
				return null;
			}
		}
		System.err.println("[Configuration{" + this.getName()
				+ "}] Error: Can not find service {" + serviceName + "}");
		return null;
	}

	public Object callServiceToConfiguration(String serviceName,
			Map<String, Object> args, Configuration c) {
		synchronized (this.links) {
			for (Link l : this.links) {
				Port port = (Port) l.getTo();
				synchronized (c.interfaces) {
					for (Interface i : c.interfaces) {
						if (i.equals(port)) {
							System.out.println("[Configuration{"
									+ this.getName() + "}] Call service {"
									+ serviceName + "} on Configuration{"
									+ c.getName() + "}");
							Object result = c.callService(serviceName, args);
							if (result != null) {
								System.out.println("[Configuration{"
										+ this.getName()
										+ "}] got service response from {"
										+ serviceName + "} on Configuration{"
										+ c.getName() + "}");
							} else {
								System.err
										.println("[Configuration{"
												+ this.getName()
												+ "}] can not get service response on Configuration{"
												+ c.getName() + "}");
							}
							return result;
						}
					}
				}
			}
		}
		return null;
	}

	private boolean containsService(String serviceName) {
		synchronized (this.interfaces) {
			for (Interface i : this.interfaces) {
				if (i instanceof Service) {
					if (i.getName().equalsIgnoreCase(serviceName)) {
						return true;
					}
				}
			}
		}
		synchronized (this.elements) {
			for (Element e : this.elements) {
				if (e instanceof Component) {
					synchronized (((Component) e).interfaces) {
						for (Interface i : ((Component) e).interfaces) {
							if (i.getName().equalsIgnoreCase(serviceName)) {
								return true;
							}
						}
					}
				} else if (e instanceof Configuration) {
					if (((Configuration) e).containsService(serviceName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Role getRoleConnectedWith(Role r) {
		synchronized (this.elements) {
			for (Element e : this.elements) {
				if (e instanceof AtomicConnector) {
					List<Glue> glues = ((AtomicConnector) e).getGlues();
					synchronized (glues) {
						for (Glue g : glues) {
							if (g.getFrom().equals(r) || g.getTo().equals(r)) {
								System.out.println("[Configuration{"
										+ this.getName() + "}] Using Glue{"
										+ g.getName() + "} in connector {"
										+ e.getName() + "}");
								Role r1, r2;
								String sens = "->";
								if (g.getFrom().equals(r)) {
									r1 = g.getFrom();
									r2 = g.getTo();
								} else {
									r1 = g.getTo();
									r2 = g.getFrom();
									sens = "<-";
								}
								System.out.println("\tRole{" + r1.getName()
										+ "} " + sens + " Role{" + r2.getName()
										+ "}");
								return r2;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public Port getAttachedFromRole(Role r) {
		synchronized (this.links) {
			for (Link l : this.links) {
				if (l instanceof Attachement) {
					if (((Attachement) l).getFrom().equals(r)) {
						System.out.println("[Configuration{" + this.getName()
								+ "}] Using Attachement{" + l.getName() + "}");
						System.out.println("\tRole{" + l.getFrom().getName()
								+ "} -> Port{" + l.getTo().getName() + "}");
						return (Port) l.getTo();
					}
				}
			}
		}
		return null;
	}

	public Port getAttachedToRole(Role r) {
		synchronized (this.links) {
			for (Link l : this.links) {
				if (l instanceof Attachement) {
					System.out.println("Link l:" + l.getName());
					System.out.println("From:" + l.getFrom().getName()
							+ ", to: " + l.getTo().getName());
					if (((Attachement) l).getTo().equals(r)) {
						System.out.println("[Configuration{" + this.getName()
								+ "}] Using Attachement{" + l.getName() + "}");
						System.out.println("\tPort{" + l.getFrom().getName()
								+ "} -> Role{" + l.getTo().getName() + "}");
						return (Port) l.getFrom();
					}
				}
			}
		}
		return null;
	}

	public Role getAttachedFromPort(Interface i) {
		synchronized (this.links) {
			for (Link l : this.links) {
				if (l instanceof Attachement) {
					if (((Attachement) l).getTo().equals(i)) {
						if (l.getFrom() instanceof Role) {
							System.out.println("[Configuration{"
									+ this.getName() + "}] Using Attachement{"
									+ l.getName() + "}");
							System.out.println("\tRole{"
									+ l.getFrom().getName() + "} -> Port{"
									+ l.getTo().getName() + "}");
							return (Role) l.getFrom();
						}
					}
				}
			}
		}
		return null;
	}

	public Role getAttachedToPort(Interface i) {
		synchronized (this.links) {
			for (Link l : this.links) {
				if (l instanceof Attachement) {
					if (((Attachement) l).getFrom().equals(i)) {
						if (l.getTo() instanceof Role) {
							System.out.println("[Configuration{"
									+ this.getName() + "}] Using Attachement{"
									+ l.getName() + "}");
							System.out.println("\tPort{"
									+ l.getFrom().getName() + "} -> Role{"
									+ l.getTo().getName() + "}");
							return (Role) l.getTo();
						}
					}
				}
			}
		}
		return null;
	}

	public Object callServiceFromPort(String serviceName,
			Map<String, Object> args, Port port) {
		Role r = this.getAttachedToPort(port);
		if (r != null) {
			Port p = this.getAttachedFromRole(this.getRoleConnectedWith(r));
			System.out.println("[Configuration{" + this.getName()
					+ "}] Call service {" + serviceName + "} on Port{"
					+ p.getName() + "}");
			synchronized (this.elements) {
				for (Element e : this.elements) {
					if (e instanceof Component) {
						List<Interface> intfces = ((Component) e).interfaces;
						for (Interface i : intfces) {
							if (i instanceof Port
									&& ((Port) i).getType().equals(
											InterfaceType.PROVIDED)) {
								if (i.equals(p)) {
									System.out.println("[Configuration{"
											+ this.getName()
											+ "}] Call service {" + serviceName
											+ "} on Component{" + e.getName()
											+ "}");
									Object result = this.callService(
											serviceName, args);
									if (result != null) {
										System.out
												.println("[Configuration{"
														+ this.getName()
														+ "}] got service response from {"
														+ serviceName
														+ "} on Component{"
														+ e.getName() + "}");
									} else {
										System.err.println("[Configuration{"
												+ this.getName()
												+ "}] can not get service "
												+ "response  on Component{"
												+ e.getName() + "}");
									}
									return result;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
