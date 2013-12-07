package m0.main;

import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;
import m1.server.RPCServeurPort;
import m2.interfaces.InterfaceType;

public class Main {

	public static void main(String[] args) {
		String globalConfigName = "global configuration";
		RPCPort intfce = new RPCPort("rpcport", 10);

		GlobalConfiguration globalConfiguration = new GlobalConfiguration(
				globalConfigName, intfce);

		RPCServeurPort rpcServeurPort = new RPCServeurPort("rpc-serveur-port",
				InterfaceType.PROVIDED);

	}
}
