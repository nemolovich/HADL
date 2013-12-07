package m2.interfaces;

public abstract class Port extends Interface {

	private int numPort;

	public Port(String name, InterfaceType type, int numPort) {
		super(name, type);
		this.setNumPort(numPort);
	}

	/**
	 * @return the numPort
	 */
	public int getNumPort() {
		return this.numPort;
	}

	/**
	 * @param numPort
	 *            the numPort to set
	 */
	public void setNumPort(int numPort) {
		this.numPort = numPort;
	}

}
