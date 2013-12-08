package m0.main;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

import m1.client.ClientComponent;
import m1.client.ClientProvidedPort;
import m1.configuration.GlobalConfiguration;

public class ClientLauncher {

	public static void main(String[] args) {
		ClientProvidedPort clientProvidedPort = new ClientProvidedPort(2003);

		ClientComponent client = new ClientComponent(clientProvidedPort);

		client.setName("GOHIER");
		client.setPassword("password");

		// client.setName("COUTABLE");
		// client.setPassword("motdepasse");

		int port = 1100;
		String url = null;
		try {
			url = "//" + InetAddress.getLocalHost().getHostName() + ":" + port
					+ "/GlobalConfiguration";
			IRemoteConfiguration remote = (IRemoteConfiguration) Naming
					.lookup(url);
			GlobalConfiguration globalConfiguration = remote.getConfiguration();

			globalConfiguration.addElement(client);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		System.out.println("Connected: " + client.isConnected());

		client.doRequest("user", "name", "*", Arrays.asList("*"));
	}

}
