package m1.server;

import m1.server.authentification.AuthDBAttachement;
import m1.server.authentification.AuthFrom;
import m1.server.authentification.AuthGlue;
import m1.server.authentification.AuthProvidedPort;
import m1.server.authentification.AuthRequiredPort;
import m1.server.authentification.AuthSecAttachement;
import m1.server.authentification.AuthService;
import m1.server.authentification.AuthTo;
import m1.server.authentification.AuthentificationConnector;
import m1.server.authentification.ConnectionManager;
import m1.server.database.DBAuthAttachement;
import m1.server.database.DBFrom;
import m1.server.database.DBGlue;
import m1.server.database.DBProvidedPort;
import m1.server.database.DBRequiredPort;
import m1.server.database.DBSecAttachement;
import m1.server.database.DBServiceAuth;
import m1.server.database.DBServiceRequest;
import m1.server.database.DBTo;
import m1.server.database.DatabaseConnector;
import m1.server.database.DatabaseManager;
import m1.server.security.SecAuthAttachement;
import m1.server.security.SecDBAttachement;
import m1.server.security.SecFrom;
import m1.server.security.SecGlue;
import m1.server.security.SecProvidedPort;
import m1.server.security.SecRequiredPort;
import m1.server.security.SecService;
import m1.server.security.SecTo;
import m1.server.security.SecurityConnector;
import m1.server.security.SecurityManager;
import m2.element.Configuration;
import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;

public class ServeurConfiguration extends Configuration {

	/**
	 * ID
	 */
	private static final long serialVersionUID = -5873111006021950767L;

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
				authProvidedPort);
		connectionManager.addInterface(authRequiredPort);
		DatabaseManager databaseManager = new DatabaseManager(dbProvidedPort);
		databaseManager.addInterface(dbRequiredPort);
		SecurityManager securityManager = new SecurityManager(secProvidedPort);
		securityManager.addInterface(secRequiredPort);

		this.addElements(connectionManager, databaseManager, securityManager);

		// instanciation des services
		AuthService authService = new AuthService();
		DBServiceRequest dbServiceRequest = new DBServiceRequest();
		DBServiceAuth dbServiceAuth = new DBServiceAuth();
		SecService secService = new SecService();
		connectionManager.addInterfaces(authService);
		databaseManager.addInterface(dbServiceRequest);
		databaseManager.addInterface(dbServiceAuth);
		securityManager.addInterface(secService);

		// instanciation des connecteurs
		AuthentificationConnector authentificationConnector = new AuthentificationConnector();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		SecurityConnector securityConnector = new SecurityConnector();
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
			AuthGlue authGlue = new AuthGlue(roleAuthFrom, roleAuthTo);
			authentificationConnector.addGlues(authGlue);
			authentificationConnector.addRoles(roleAuthFrom, roleAuthTo);
			DBGlue dbGlue = new DBGlue(roleDbFrom, roleDbTo);
			databaseConnector.addGlues(dbGlue);
			databaseConnector.addRoles(roleDbFrom, roleDbTo);
			SecGlue secGlue = new SecGlue(roleSecFrom, roleSecTo);
			securityConnector.addGlues(secGlue);
			securityConnector.addRoles(roleSecFrom, roleSecTo);
		} catch (NonDifferentsTypesException e) {
			e.printStackTrace();
		}

		// instanciation des Attachements
		try {
			// Auth --> AuthGlue
			AuthDBAttachement authDBAttachement = new AuthDBAttachement(
					authRequiredPort, roleAuthFrom);
			this.addLink(authDBAttachement);
			// AuthGlue --> DB
			DBAuthAttachement dbAuthAttachement = new DBAuthAttachement(
					roleAuthTo, dbProvidedPort);
			this.addLink(dbAuthAttachement);
			// DB --> DBGlue
			DBSecAttachement dbSecAttachement = new DBSecAttachement(
					dbRequiredPort, roleDbFrom);
			this.addLink(dbSecAttachement);
			// DBGlue --> Sec
			SecDBAttachement secDBAttachement = new SecDBAttachement(roleDbTo,
					secProvidedPort);
			this.addLink(secDBAttachement);
			// Sec --> SecGlue
			SecAuthAttachement secAuthAttachement = new SecAuthAttachement(
					secRequiredPort, roleSecFrom);
			this.addLink(secAuthAttachement);
			// SecGlue --> Auth
			AuthSecAttachement authSecAttachement = new AuthSecAttachement(
					roleSecTo, authProvidedPort);
			this.addLink(authSecAttachement);
		} catch (NonDifferentsTypesException e1) {
			e1.printStackTrace();
		}

		// Connection Service
		ConnectionService connectionService = new ConnectionService();
		this.addInterface(connectionService);

	}
}
