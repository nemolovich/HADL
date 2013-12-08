package m1.configuration;

import java.util.Arrays;

import m1.client.ClientComponent;
import m1.client.ClientProvidedPort;
import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;
import m1.server.configuration.RPCConfPort;
import m2.element.Configuration;
import m2.exception.NonDifferentsTypesException;
import m2.exception.NonProvidedTypeTo;
import m2.exception.NonRequiredTypeFrom;

public class GlobalConfiguration extends Configuration {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5114287978857251405L;

	public GlobalConfiguration(String name, RPCPort intfce) {
		super(name, intfce);

		RPCConfPort rpcConfPort = new RPCConfPort(2102);
		this.addInterface(rpcConfPort);

		RPCServeurPort rpcServeurPort = new RPCServeurPort(2002);
		ServeurConfiguration serveur = new ServeurConfiguration(
				"ServeurConfiguration", rpcServeurPort);
		ClientProvidedPort clientProvidedPort = new ClientProvidedPort(2003);
		ClientComponent client1 = new ClientComponent(clientProvidedPort);
		ClientComponent client2 = new ClientComponent(clientProvidedPort);

		try {
			RPCBinding rpcBinding = new RPCBinding(rpcConfPort, rpcServeurPort);
			this.addLink(rpcBinding);
		} catch (NonRequiredTypeFrom e) {
			e.printStackTrace();
		} catch (NonProvidedTypeTo e) {
			e.printStackTrace();
		}

		RPCConnector rpcConnector = new RPCConnector();
		RPCFrom rpcFrom = new RPCFrom();
		RPCTo rpcTo = new RPCTo();
		try {
			RPCGlue rpcGlue = new RPCGlue(rpcFrom, rpcTo);
			rpcConnector.addGlue(rpcGlue);
		} catch (NonDifferentsTypesException e) {
			e.printStackTrace();
		}
		this.addElement(rpcConnector);

		try {
			// Conf --> ConfGlue
			RPCAttachement rpcAttachement = new RPCAttachement(rpcConfPort,
					rpcFrom);
			this.addLink(rpcAttachement);
			serveur.addLink(rpcAttachement);
			// ConfGlue --> Serv
			RPCServerAttachement rpcServerAttachement = new RPCServerAttachement(
					rpcTo, rpcServeurPort);
			this.addLink(rpcServerAttachement);
			serveur.addLink(rpcServerAttachement);
		} catch (NonDifferentsTypesException e) {
			e.printStackTrace();
		}

		this.addElement(serveur);
		this.addElement(client1);
		this.addElement(client2);

		client1.setName("GOHIER");
		client1.setPassword("password");

		client2.setName("COUTABLE");
		client2.setPassword("motdepasse");

		System.out.println(client1.isConnected());
		System.out.println(client2.isConnected());

		client1.doRequest("user", "name", "*", Arrays.asList("*"));
		client2.doRequest("user", "name", "*", Arrays.asList("*"));
	}
}
