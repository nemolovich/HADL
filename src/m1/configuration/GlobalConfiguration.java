package m1.configuration;

import m1.server.RPCServeurPort;
import m1.server.ServeurConfiguration;
import m1.server.configuration.RPCConfPort;
import m2.element.Configuration;
import m2.exception.NoDifferentsTypesException;
import m2.exception.NoProvidedTypeTo;
import m2.exception.NoRequiredTypeFrom;

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

		try {
			RPCBinding rpcBinding = new RPCBinding(rpcConfPort, rpcServeurPort);
			this.addLink(rpcBinding);
		} catch (NoRequiredTypeFrom e) {
			e.printStackTrace();
		} catch (NoProvidedTypeTo e) {
			e.printStackTrace();
		}

		RPCConnector rpcConnector = new RPCConnector();
		RPCFrom rpcFrom = new RPCFrom();
		RPCTo rpcTo = new RPCTo();
		try {
			RPCGlue rpcGlue = new RPCGlue(rpcFrom, rpcTo);
			rpcConnector.addGlue(rpcGlue);
		} catch (NoDifferentsTypesException e) {
			e.printStackTrace();
		}
		this.addElement(rpcConnector);
		serveur.addElement(rpcConnector);

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
		} catch (NoDifferentsTypesException e) {
			e.printStackTrace();
		}

		this.addElement(serveur);
	}
}
