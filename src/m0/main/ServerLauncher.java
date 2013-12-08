package m0.main;

import java.net.BindException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;
import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;

public class ServerLauncher {
	public static void main(String[] args) {

		int port = 1100;
		try {
			System.out.println("[ Trying registry with port " + port + " ]");

			LocateRegistry.createRegistry(port);

			RPCPort rpcPort = new RPCPort(2001);

			GlobalConfiguration globalConfiguration = new GlobalConfiguration(
					"GlobalConfiguration", rpcPort);
			RPCServeurPort rpcServeurPort = new RPCServeurPort(2002);
			ServeurConfiguration serveur = new ServeurConfiguration(
					"ServeurConfiguration", rpcServeurPort);

			globalConfiguration.addElement(serveur);

			RemoteConfiguration remoteConfiguration = new RemoteConfiguration(
					globalConfiguration);

			String url = "//" + InetAddress.getLocalHost().getHostName() + ":"
					+ port + "/GlobalConfiguration";
			System.out.println("[ Registry of object with URL  ] : " + url);
			Naming.rebind(url, remoteConfiguration);

			System.out.println("[ CONFIGURATION ENGAGED ]");
		} catch (ExportException e) {
			if (e.getCause() instanceof BindException) {
				System.err
						.println("The server can not be started on this port: "
								+ port);
			}
			e.printStackTrace();
			System.exit(0);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
