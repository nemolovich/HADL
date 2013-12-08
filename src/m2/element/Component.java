package m2.element;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import m2.interfaces.Interface;
import m2.interfaces.InterfaceType;
import m2.interfaces.Port;
import m2.interfaces.Service;
import m2.link.Link;

/**
 * 
 * @author Guillaume Coutable, Brian Gohier
 * 
 */
public abstract class Component extends Element {

	protected List<Link> links;
	protected List<Interface> interfaces;

	public Component(String name, Interface intfce) {
		super(name);
		this.interfaces = new ArrayList<Interface>();
		this.links = new ArrayList<Link>();
		this.addInterface(intfce);
	}

	/*
	 * Links
	 */

	/**
	 * Check if this configuration contains the specified link
	 * 
	 * @param link
	 *            whose presence in this configuration is to be tested
	 * @return {@code true} if this configuration contain the specified link
	 */
	public boolean containsLink(Link link) {
		synchronized (this.links) {
			return this.links.contains(link);
		}
	}

	/**
	 * Add link
	 * 
	 * @param link
	 *            to add
	 * @return {@code true} if the link had been added
	 */
	public boolean addLink(Link link) {
		synchronized (this.links) {
			return this.links.add(link);
		}
	}

	/**
	 * Add a list of links
	 * 
	 * @param links
	 *            to add
	 * @return {@code true} if links had all been added
	 */
	public boolean addLinks(List<Link> links) {
		synchronized (this.links) {
			return this.links.addAll(links);
		}
	}

	/**
	 * Add links
	 * 
	 * @param links
	 *            to add
	 * @return {@code true} if links had all been added
	 */
	public boolean addLinks(Link... links) {
		boolean added = true;
		synchronized (this.links) {
			for (Link l : links) {
				added &= this.links.add(l);
			}
		}
		return added;
	}

	/**
	 * remove the link from this configuration
	 * 
	 * @param link
	 *            to remove
	 * @return {@code true} if this configuration contained the specified link
	 */
	public boolean removeLink(Link link) {
		synchronized (this.links) {
			return this.links.remove(link);
		}
	}

	/*
	 * Interfaces
	 */

	/**
	 * Check if this configuration contains the specified interface
	 * 
	 * @param interface whose presence in this configuration is to be tested
	 * @return {@code true} if this configuration contain the specified
	 *         interface
	 */
	public boolean containsInterface(Interface intfce) {
		synchronized (this.interfaces) {
			return this.interfaces.contains(intfce);
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
	public boolean hasService(String serviceName) {
		synchronized (this.interfaces) {
			for (Interface i : this.interfaces) {
				if (i instanceof Service
						&& ((Service) i).getName()
								.equalsIgnoreCase(serviceName)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Add interface
	 * 
	 * @param interface to add
	 * @return {@code true} if the interface had been added
	 */
	public boolean addInterface(Interface intfce) {
		synchronized (this.interfaces) {
			intfce.setComponent(this);
			return this.interfaces.add(intfce);
		}
	}

	/**
	 * Add a list of interfaces
	 * 
	 * @param interfaces
	 *            to add
	 * @return {@code true} if interfaces had all been added
	 */
	public boolean addInterfaces(List<Interface> interfaces) {
		synchronized (this.interfaces) {
			synchronized (interfaces) {
				for (Interface itf : interfaces) {
					itf.setComponent(this);
				}
			}
			return this.interfaces.addAll(interfaces);
		}
	}

	/**
	 * Add interfaces
	 * 
	 * @param interfaces
	 *            to add
	 * @return {@code true} if interfaces had all been added
	 */
	public boolean addInterfaces(Interface... interfaces) {
		boolean added = true;
		synchronized (this.interfaces) {
			for (Interface i : interfaces) {
				i.setComponent(this);
				added &= this.interfaces.add(i);
			}
		}
		return added;
	}

	/**
	 * remove the interface from this configuration
	 * 
	 * @param interface to remove
	 * @return {@code true} if this configuration contained the specified
	 *         interface
	 */
	public boolean removeInterface(Interface intfce) {
		synchronized (this.interfaces) {
			return this.interfaces.remove(intfce);
		}
	}

	public Object callService(String serviceName, Map<String, Object> params) {
		synchronized (this.interfaces) {
			for (Interface i : this.interfaces) {
				if (i instanceof Port
						&& ((Port) i).getType().equals(InterfaceType.REQUIRED)) {
					System.out.println("[Component{" + this.getName()
							+ "}] Call service {" + serviceName + "} on port {"
							+ i.getName() + "}");
					return this.configuration.callServiceFromPort(serviceName,
							params, (Port) i);
				}
			}
		}
		return null;
	}
}
