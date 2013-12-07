package m2.interfaces;

public abstract class Port extends Interface {

	private int numPort;

	public Port(String name, InterfaceType type, int numPort) {
		super(name, type);
		this.numPort = numPort;
	}

}
