package m1.server.database;

import java.util.Map;

import m2.exception.ServiceException;
import m2.exception.WrongServiceArgumentType;
import m2.exception.WrongServiceArguments;
import m2.exception.WrongServiceNumberArguments;
import m2.interfaces.InterfaceType;
import m2.interfaces.Service;

/**
 * This service will search an user name in the database, if it is found, it
 * will return the password corresponding to this user name.
 * 
 * @param user
 *            {@link String String.class} - The user name
 * @return {@link String String.class} - The password for given user
 * 
 * @author Guillaume COUTABLE, Brian GOHIER
 * @see {@link Service}
 */
public class DBServiceAuth extends Service {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 7602708463944611257L;

	public DBServiceAuth() {
		super("DBServiceAuth", InterfaceType.PROVIDED);
		this.addParameter("user", String.class);
		this.setReturnType(String.class);
	}

	@Override
	public Object call(Map<String, Object> args) throws ServiceException {
		this.describe(args);
		if (args.size() != this.args.size()) {
			throw new WrongServiceNumberArguments(this.getName(),
					this.args.size());
		}
		synchronized (this.args) {
			for (String param : this.args.keySet()) {
				if (!args.containsKey(param)) {
					throw new WrongServiceArguments(this.getName());
				} else if (!this.args.get(param).isAssignableFrom(
						args.get(param).getClass())) {
					throw new WrongServiceArgumentType(this.getName(), param,
							this.args.get(param));
				}
			}
		}
		DBServiceRequest dbServiceRequest = new DBServiceRequest();
		String user = (String) args.get("user");
		Map<Integer, String> value = dbServiceRequest.getValue("user", "name");
		if (value.size() < 1) {
			System.err.println("[DBServiceAuth] No match attribute found");
			return false;
		}
		Integer id = null;
		for (Integer i : value.keySet()) {
			if (value.get(i).equals(user)) {
				id = i;
			}
		}
		if (id == null) {
			System.err.println("[DBServiceAuth] No match value found");
			return false;
		}
		return this.returnType.cast(dbServiceRequest.getAttrValue("user",
				"password", id));
	}

}
