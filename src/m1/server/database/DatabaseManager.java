package m1.server.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import m2.element.Component;
import fr.univ.nantes.StringUtil.StringUtil;

public class DatabaseManager extends Component {

	private Properties data = null;
	private Properties dbSchema = null;
	private Properties lastIdOfTable = null;

	private static final String DATABASE = "./sql/data.db";
	private static final String DATABASECOMMENT = "Our wonderfull database";

	private static final String DBSCHEMA = "./sql/DatabaseSchema.db";
	private static final String DBSCHEMACOMMENT = "tableName=attributs, semi-colon separated";

	private static final String LASTID = "./sql/LastIds.properties";
	private static final String LASTIDCOMMENT = "table=lastId";

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
			this.data.load(new FileReader(DATABASE));
			opened = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	 * Open the database schem, return <code>true</code> if the file has been
	 * correctly read, <code>false</code> otherwise
	 * 
	 * @return {@link Boolean boolean} - <code>true</code> if the file has been
	 *         correctly read, <code>false</code> otherwise
	 */
	private boolean openSchema() {
		boolean opened = false;
		try {
			this.dbSchema = new Properties();
			this.dbSchema.load(new FileReader(DBSCHEMA));
			opened = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return opened;
	}

	/**
	 * Close the database schema
	 */
	private void closeSchema() {
		this.dbSchema = null;
	}

	/**
	 * Open the File containing the id of each table. Return <code>true</code>
	 * if the file has been correctly read, <code>false</code> otherwise
	 * 
	 * @return {@link Boolean boolean} - <code>true</code> if the file has been
	 *         correctly read, <code>false</code> otherwise
	 */
	private boolean openLastIdFile() {
		boolean opened = false;
		try {
			this.lastIdOfTable = new Properties();
			this.lastIdOfTable.load(new FileReader(LASTID));
			opened = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return opened;
	}

	/**
	 * Close the File containing the id of each table.
	 */
	private void closeLastIdFile() {
		this.lastIdOfTable = null;
	}

	/**
	 * Return the list of attributs' tableName table
	 * 
	 * @param tableName
	 *            the table which we want attributs' name
	 * @return the list attributs' tableName table
	 * 
	 * @pre the file containing last id's must be opened
	 */
	private List<String> getAttributesName(String tableName) {

		List<String> attributList = new ArrayList<String>();
		String attributs = this.dbSchema.getProperty(tableName);

		for (String attr : attributs.split(";")) {
			attributList.add(attr);
		}

		return attributList;
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

	/**
	 * Create a new table
	 * 
	 * @param tableName
	 *            the new name's table
	 * @param attributs
	 *            the attributs' name of the table
	 * @return {@link Boolean boolean} - <code>true</code> if the table had been
	 *         created, <code>false</code> otherwise (include the case where the
	 *         table already exist)
	 */
	public boolean createTable(String tableName, String... attributs) {
		boolean created = true;

		// ouverture du fichier du schéma de la base de données
		created &= this.openSchema();

		// verification que la table n'existe
		boolean exist = false;
		Iterator<Object> io = this.dbSchema.keySet().iterator();
		while (io.hasNext() && !exist) {
			String nexts = (String) io.next();
			exist |= (nexts.equals(tableName));
		}

		if (exist) {
			created = !exist;
			System.err.println("The table " + tableName + "already exist");
		} else {
			// ajout de la nouvelle table dans le schéma
			List<String> stringList = new ArrayList<String>();
			for (String s : attributs) {
				stringList.add(s);
			}
			String attr = StringUtil.join(stringList, ";");
			this.dbSchema.put(tableName, attr);

			// enregistrement du schéma
			try {
				this.dbSchema.store(new FileWriter(DBSCHEMA, true),
						DBSCHEMACOMMENT);
			} catch (IOException e) {
				e.printStackTrace();
				created = false;
			}
		}
		// fermeture du schéma de la table
		this.closeSchema();
		return created;
	}

	public boolean addTuple(String tableName, String... attributsValues) {
		boolean added = true;

		// ouverture du fichier contenant le dernier Id de chaque table
		added &= this.openLastIdFile();

		// ouverture du fichier de schéma de la base de données
		added &= this.openSchema();

		// ouverture de la base de donnée
		added &= this.connect();

		// TODO: vérifier que la table `tableName` existe

		// récupération du dernier Id de la table `tableName`
		int lastId = Integer.decode(this.lastIdOfTable.getProperty(tableName));
		lastId++;

		// récupération des attributs de la table `tableName`
		List<String> attributList = this.getAttributesName(tableName);

		if (attributList.size() != attributsValues.length) {
			added &= false;
			System.out.println(attributList.size() + ", "
					+ attributsValues.length);
		} else {

			// ajout du nouveau Tuple dans la base
			String key = "";
			for (int i = 0; i < attributList.size(); ++i) {
				key = tableName + "." + lastId + "." + attributList.get(i);
				this.data.put(key, attributsValues[i]);
			}

			// enregistrement du nouveau tuple dans la base
			try {
				this.data.store(new FileWriter(DATABASE), DATABASECOMMENT);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// mise à jour du dernier Id
			this.lastIdOfTable.setProperty(tableName, String.valueOf(lastId));
			try {
				this.lastIdOfTable.store(new FileWriter(LASTID), LASTIDCOMMENT);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// fermeture de la base de données
		this.close();
		this.closeSchema();
		this.closeLastIdFile();

		return added;
	}

	/**
	 * Remove the tuple from the table `tableName`, corresponding to the id `id`
	 * 
	 * @param tableName
	 *            the table which contains the Id `id`
	 * @param id
	 *            the Id to remove
	 * @return {@link Boolean boolean} - <code>true</code> if the tuple had been
	 *         remove, <code>false</code> otherwise.
	 */
	public boolean removeTuple(String tableName, int id) {
		boolean removed = true;
		// overture des fichiers de la bd
		removed &= this.connect();
		removed &= this.openLastIdFile();
		removed &= this.openSchema();

		// récupération des attributs
		List<String> attributList = this.getAttributesName(tableName);

		// création des clef représentant le Tuple
		List<String> keyList = new ArrayList<String>();
		for (String attr : attributList) {
			keyList.add(tableName + "." + id + "." + attr);
		}

		// suppression du tuple de la base
		for (String key : keyList) {
			this.data.remove(key);
		}

		// mise à jour de la base de données
		try {
			this.data.store(new FileWriter(DATABASE), DATABASECOMMENT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.closeSchema();
		this.closeLastIdFile();
		this.close();

		return removed;
	}

	/**
	 * Remove from the database, the table `tableName`
	 * 
	 * @param tableName
	 *            the table to remove
	 * @return {@link Boolean boolean} - <code>true</code> if the table had been
	 *         removed, <code>false</code> otherwise.
	 */
	public boolean removeTable(String tableName) {
		boolean removed = true;
		// overture des fichiers de la bd
		removed &= this.connect();
		removed &= this.openLastIdFile();
		removed &= this.openSchema();

		// suppression de la table dans la bd
		Set<Object> toRmv = new HashSet<Object>();
		for (Object s : this.data.keySet()) {
			if (Pattern.matches(tableName + ".*", (String) s)) {
				// suppression des lignes dont les clefs correspondent au
				// pattern "tablename.*"
				toRmv.add(s);
			}
		}

		for (Object o : toRmv) {
			this.data.remove(o);
		}

		// mise à jour de la base de données
		try {
			this.data.store(new FileWriter(DATABASE), DATABASECOMMENT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// suppression de la table dans le schéma
		this.dbSchema.remove(tableName);
		try {
			this.dbSchema.store(new FileWriter(DBSCHEMA), DBSCHEMACOMMENT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// suppression de la table dans le fichier d'ID
		this.lastIdOfTable.remove(tableName);
		try {
			this.lastIdOfTable.store(new FileWriter(LASTID), LASTIDCOMMENT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.closeSchema();
		this.closeLastIdFile();
		this.close();

		return removed;
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
