package m0.main;

import m1.configuration.GlobalConfiguration;
import m1.configuration.RPCPort;

public class Main {

	public static void main(String[] args) {
		RPCPort rpcPort = new RPCPort(2001);

		new GlobalConfiguration("GlobalConfiguration", rpcPort);
	}
}
