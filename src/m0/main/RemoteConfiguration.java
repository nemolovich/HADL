package m0.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import m1.configuration.GlobalConfiguration;

public class RemoteConfiguration extends UnicastRemoteObject implements
		IRemoteConfiguration {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -7181367148338358414L;
	private GlobalConfiguration congiguration;

	protected RemoteConfiguration(GlobalConfiguration configuration)
			throws RemoteException {
		super();
		this.congiguration = configuration;
	}

	@Override
	public GlobalConfiguration getConfiguration() throws RemoteException {
		return this.congiguration;
	}

}
