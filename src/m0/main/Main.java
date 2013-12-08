package m0.main;

import java.util.Arrays;

import m1.client.ClientComponent;
import m1.client.ClientProvidedPort;
import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;
import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;

public class Main {

	public static void main(String[] args) {
		RPCPort rpcPort = new RPCPort(2001);

		GlobalConfiguration globalConfiguration = new GlobalConfiguration(
				"GlobalConfiguration", rpcPort);
		RPCServeurPort rpcServeurPort = new RPCServeurPort(2002);
		ServeurConfiguration serveur = new ServeurConfiguration(
				"ServeurConfiguration", rpcServeurPort);
		ClientProvidedPort clientProvidedPort = new ClientProvidedPort(2003);
		ClientComponent client1 = new ClientComponent(clientProvidedPort);
		ClientComponent client2 = new ClientComponent(clientProvidedPort);

		globalConfiguration.addElement(serveur);
		globalConfiguration.addElement(client1);
		globalConfiguration.addElement(client2);

		client1.setName("GOHIER");
		client1.setPassword("password");

		client2.setName("COUTABLE");
		client2.setPassword("password");

		System.out.println(client1.isConnected());
		System.out.println(client2.isConnected());

		client1.doRequest("user", "name", "*", Arrays.asList("*"));
		client2.doRequest("user", "name", "*", Arrays.asList("*"));
	}
}
