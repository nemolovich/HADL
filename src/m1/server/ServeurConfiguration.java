package m1.server;

import m1.server.authentification.AuthDBAttachement;
import m1.server.authentification.AuthFrom;
import m1.server.authentification.AuthGlue;
import m1.server.authentification.AuthProvidedPort;
import m1.server.authentification.AuthRequiredPort;
import m1.server.authentification.AuthService;
import m1.server.authentification.AuthTo;
import m1.server.authentification.AuthentificationConnector;
import m1.server.authentification.ConnectionManager;
import m1.server.database.DBAuthAttachement;
import m1.server.database.DBFrom;
import m1.server.database.DBGlue;
import m1.server.database.DBProvidedPort;
import m1.server.database.DBRequiredPort;
import m1.server.database.DBService;
import m1.server.database.DBTo;
import m1.server.database.DatabaseConnector;
import m1.server.database.DatabaseManager;
import m1.server.security.SecFrom;
import m1.server.security.SecGlue;
import m1.server.security.SecProvidedPort;
import m1.server.security.SecRequiredPort;
import m1.server.security.SecTo;
import m1.server.security.SecurityConnector;
import m1.server.security.SecurityManager;
import m2.element.Configuration;
import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;

public class ServeurConfiguration extends Configuration {

	public ServeurConfiguration(String name, Interface intfce) {
		super(name, intfce);

		// instanciation des Ports
		AuthProvidedPort authProvidedPort = new AuthProvidedPort(2400);
		AuthRequiredPort authRequiredPort = new AuthRequiredPort(2300);
		DBProvidedPort dbProvidedPort = new DBProvidedPort(2401);
		DBRequiredPort dbRequiredPort = new DBRequiredPort(2301);
		SecProvidedPort secProvidedPort = new SecProvidedPort(2402);
		SecRequiredPort secRequiredPort = new SecRequiredPort(2302);

		// instanciation des Managers
		ConnectionManager connectionManager = new ConnectionManager(
				"connectionManager", authProvidedPort);
		connectionManager.addInterface(authRequiredPort);
		DatabaseManager databaseManager = new DatabaseManager(
				"dataBaseManager", dbProvidedPort);
		databaseManager.addInterface(dbRequiredPort);
		SecurityManager securityManager = new SecurityManager(
				"securityManager", secProvidedPort);
		securityManager.addInterface(secRequiredPort);

		this.addElements(connectionManager, databaseManager, securityManager);

		// instanciation des services
		AuthService authService = new AuthService();
		DBService dbService = new DBService();
		connectionManager.addInterfaces(authService);
		databaseManager.addInterface(dbService);

		// instanciation des connecteurs
		AuthentificationConnector authentificationConnector = new AuthentificationConnector(
				"authentificationConnector");
		DatabaseConnector databaseConnector = new DatabaseConnector(
				"databaseConnector");
		SecurityConnector securityConnector = new SecurityConnector(
				"securityConnector");
		this.addElements(authentificationConnector, databaseConnector,
				securityConnector);

		// instanciation des Roles
		AuthFrom roleAuthFrom = new AuthFrom();
		AuthTo roleAuthTo = new AuthTo();

		DBFrom roleDbFrom = new DBFrom();
		DBTo roleDbTo = new DBTo();

		SecFrom roleSecFrom = new SecFrom();
		SecTo roleSecTo = new SecTo();

		// instanciation des Glues
		try {
			AuthGlue authGlue = new AuthGlue("authGlue", roleAuthFrom,
					roleAuthTo);
			authentificationConnector.addGlues(authGlue);
			authentificationConnector.addRoles(roleAuthFrom, roleAuthTo);
			DBGlue dbGlue = new DBGlue("dbGlue", roleDbFrom, roleDbTo);
			databaseConnector.addGlues(dbGlue);
			databaseConnector.addRoles(roleDbFrom, roleDbTo);
			SecGlue secGlue = new SecGlue("secGlue", roleSecFrom, roleSecTo);
			securityConnector.addGlues(secGlue);
			securityConnector.addRoles(roleSecFrom, roleSecTo);
		} catch (NonDifferentsTypesException e) {
			e.printStackTrace();
		}

		// instanciation des Attachements
		try {
			AuthDBAttachement authDBAttachement = new AuthDBAttachement(
					authRequiredPort, roleAuthFrom);
			this.addLink(authDBAttachement);
			DBAuthAttachement dbAuthAttachement = new DBAuthAttachement(
					roleAuthTo, dbProvidedPort);
			this.addLink(dbAuthAttachement);
		} catch (NonDifferentsTypesException e1) {
			e1.printStackTrace();
		}

	}
}
