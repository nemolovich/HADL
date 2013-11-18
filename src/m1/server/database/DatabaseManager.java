package m1.server.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import m2.element.Component;

public class DatabaseManager extends Component {

	private Properties data = null;

	public DatabaseManager(String name, DBProvidedPort port) {
		super(name, port);
	}

	/**
	 * Open the database, return <code>true</code> if the file has been
	 * correctly read, <code>false</code> otherwise
	 * 
	 * @return {@link Boolean boolean} - <code>true</code> if the file has been
	 *         correctly read, <code>false</code> otherwise
	 */
	public boolean connect() {
		boolean opened = false;

		try {
			this.data = new Properties();
			this.data.load(new FileReader("./sql/data.db"));
			opened = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return opened;
	}

	/**
	 * Close the database
	 */
	public void close() {
		this.data = null;
	}

	/**
	 * Return the database in text format
	 * 
	 * @return the database in text format
	 */
	public String displayDataBase() {
		String dataBase = "";
		for (Object key : this.data.keySet()) {
			System.out.println("Key: " + key + " = value: "
					+ this.data.get(key));
		}
		return dataBase;
	}

	public static void main(String... args) {
		DatabaseManager dm = new DatabaseManager("databaseManager",
				new DBProvidedPort("providedPort"));
		dm.connect();
		System.out.println(dm.displayDataBase());
		dm.close();
	}
}
