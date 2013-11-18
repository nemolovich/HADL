package m1.server.database;

import m2.element.Component;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class DatabaseManager extends Component {

	private Properties data;

	public DatabaseManager(String name, DBProvidedPort port) {
		super(name, port);
	}

	/**
	 * Read the file and store it in properties "data"
	 * 
	 * @return {@link Boolean boolean} - <code>true</code> if the file has been
	 *         correctly read, <code>false</code> otherwise
	 */
	public boolean connect() {
		return false;
	}
}
