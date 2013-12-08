package m0.main;

import java.util.HashMap;
import java.util.Map;

import m1.client.ClientComponent;
import m1.client.ClientProvidedPort;
import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;
import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;
import m2.interfaces.InterfaceType;

public class Main {

	public static void main(String[] args) {
		RPCPort rpcPort = new RPCPort("rpcport", 2001);

		GlobalConfiguration globalConfiguration = new GlobalConfiguration(
				"global configuration", rpcPort);
		RPCServeurPort rpcServeurPort = new RPCServeurPort("rpc-serveur-port",
				InterfaceType.PROVIDED, 2002);
		ServeurConfiguration serveur = new ServeurConfiguration(
				"serveurConfiguration", rpcServeurPort);
		ClientProvidedPort clientProvidedPort = new ClientProvidedPort(
				"client-provided-port", 2003);
		ClientComponent client = new ClientComponent("client",
				clientProvidedPort);

		globalConfiguration.addElement(serveur);
		globalConfiguration.addElement(client);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", "GOHIER");
		params.put("password", "password");

		boolean connected = (Boolean) serveur.callService(
				"AuthenticationService", params);
		System.out.println("Connected: " + connected);
	}
}
