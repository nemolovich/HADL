package m0.main;

import m1.client.ClientComponent;
import m1.client.ClientProvidedPort;
import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;
import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;
import m1.utils.Message;
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

		Message m = new Message("Auth-Message");
		m.setContent("Want connect");
		serveur.sendMessage(m);
	}
}
