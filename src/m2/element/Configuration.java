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
			synchronized (elements) {
				for (Element e : elements) {
					e.setConfiguration(this);
				}
			}
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
				e.setConfiguration(this);
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
				System.out.println("[Configuration{" + this.getName()
						+ "}] got service response from {" + serviceName + "}");
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
							System.out.println("[Configuration{"
									+ this.getName()
									+ "}] got service response from {"
									+ serviceName + "} on Configuration{"
									+ c.getName() + "}");
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
									System.out.println("[Configuration{"
											+ this.getName()
											+ "}] got service response from {"
											+ serviceName + "} on Component{"
											+ e.getName() + "}");
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
