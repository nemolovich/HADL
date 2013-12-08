package m1.server;

import m1.server.authentification.AuthFrom;
import m1.server.authentification.AuthGlue;
import m1.server.authentification.AuthProvidedPort;
import m1.server.authentification.AuthService;
import m1.server.authentification.AuthTo;
import m1.server.authentification.AuthentificationConnector;
import m1.server.authentification.ConnectionManager;
import m1.server.database.DBFrom;
import m1.server.database.DBGlue;
import m1.server.database.DBProvidedPort;
import m1.server.database.DBService;
import m1.server.database.DBTo;
import m1.server.database.DatabaseConnector;
import m1.server.database.DatabaseManager;
import m1.server.security.SecFrom;
import m1.server.security.SecGlue;
import m1.server.security.SecProvidedPort;
import m1.server.security.SecTo;
import m1.server.security.SecurityConnector;
import m1.server.security.SecurityManager;
import m2.element.Configuration;
import m2.exception.NonDifferentsTypesException;
import m2.interfaces.Interface;

public class ServeurConfiguration extends Configuration {

	public ServeurConfiguration(String name, Interface intfce) {
		super(name, intfce);

		// instanciation des Managers
		ConnectionManager connectionManager = new ConnectionManager(
				"connectionManager", new AuthProvidedPort("authProvidedPort",
						2400));
		DatabaseManager databaseManager = new DatabaseManager(
				"dataBaseManager", new DBProvidedPort("dbProvidedPort", 2401));
		SecurityManager securityManager = new SecurityManager(
				"securityManager", new SecProvidedPort("secProvidedPort", 2402));

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
		AuthFrom roleAuthFrom = new AuthFrom("authFrom");
		AuthTo roleAuthTo = new AuthTo("authTo");

		DBFrom roleDbFrom = new DBFrom("dbFrom");
		DBTo roleDbTo = new DBTo("dbTo");

		SecFrom roleSecFrom = new SecFrom("secFrom");
		SecTo roleSecTo = new SecTo("secTo");

		authentificationConnector.addRoles(roleAuthFrom, roleAuthTo);
		databaseConnector.addRoles(roleDbFrom, roleDbTo);
		securityConnector.addRoles(roleSecFrom, roleSecTo);

		// instanciation des Glues
		AuthGlue authGlue = null;
		DBGlue dbGlue = null;
		SecGlue secGlue = null;
		try {
			authGlue = new AuthGlue("authGlue", roleAuthFrom, roleAuthTo);
			dbGlue = new DBGlue("dbGlue", roleDbFrom, roleDbTo);
			secGlue = new SecGlue("secGlue", roleSecFrom, roleSecTo);
		} catch (NonDifferentsTypesException e) {
			e.printStackTrace();
		}

		authentificationConnector.addGlues(authGlue, dbGlue, secGlue);

	}

}
