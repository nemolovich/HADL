package m0.main;

import java.rmi.Remote;
import java.rmi.RemoteException;

import m1.configuration.GlobalConfiguration;

public interface IRemoteConfiguration extends Remote {
	public GlobalConfiguration getConfiguration() throws RemoteException;
}
