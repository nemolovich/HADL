package m1.server.database;

import m2.element.Component;

public class DatabaseManager extends Component {

	public DatabaseManager(String name, DBProvidedPort port) {
		super(name, port);
	}

	// public static void main(String... args) {
	// DatabaseManager dm = new DatabaseManager("databaseManager",
	// new DBProvidedPort("providedPort"));
	//
	// // System.out.println(dm.removeTable("user"));
	//
	// // System.out.println(dm.removeTuple("user", 2));
	//
	// // System.out.println(dm.addTuple("user", "COUTABLE", "guillaume"));
	//
	// // System.out.println(dm.createTable("user", "name", "firstname"));
	//
	// // dm.connect();
	// // {
	// // System.out.println(dm.displayDataBase());
	// // System.out.println(dm.getValue("user", "name"));
	// // System.out.println(dm.getAttrValue("user", "name", 2));
	// // }
	// // dm.close();
	// }
}
