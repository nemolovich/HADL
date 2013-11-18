package m1.server.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

	// TODO: finalize these comments
	/**
	 * Return a map of values which corresponding to entity and attributeName
	 * parameters.
	 * 
	 * The returned Map formating is set as follow : - an Integer as a key
	 * corresponding to identifiers' entity - a String as a value corresponding
	 * to attributes' value of the entity
	 * 
	 * @param entity
	 *            the entity
	 * @param attributeName
	 *            the attribute's name
	 * @return a map
	 */
	public Map<Integer, String> getValue(String entity, String attributeName) {
		String[] keyString;
		Map<Integer, String> values = new HashMap<Integer, String>();
		for (Object key : this.data.keySet()) {
			keyString = key.toString().split("\\.");
			if (keyString[0].equals(entity)
					&& keyString[2].equals(attributeName)) {
				values.put(Integer.decode(keyString[1]),
						(String) this.data.get(key));
			}
		}
		return values;
	}

	/**
	 * Return the attribute's value of a specific attribute's name of a specific
	 * entity, with a specific id.
	 * 
	 * @param entity
	 *            the entity
	 * @param attName
	 *            the attribute's name
	 * @param id
	 *            the entitie's id
	 * @return the attribute's value
	 */
	public String getAttrValue(String entity, String attName, int id) {
		String attValue = "";
		Map<Integer, String> values = this.getValue(entity, attName);
		attValue = values.get(id);
		return attValue;
	}

	public static void main(String... args) {
		DatabaseManager dm = new DatabaseManager("databaseManager",
				new DBProvidedPort("providedPort"));
		dm.connect();
		{
			System.out.println(dm.displayDataBase());
			System.out.println(dm.getValue("user", "name"));
			System.out.println(dm.getAttrValue("user", "name", 2));
		}
		dm.close();
	}
}
