package m1.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2.element.Component;

public class ClientComponent extends Component {

	/**
	 * ID
	 */
	private static final long serialVersionUID = 5130875137417032993L;
	private String password;

	public ClientComponent(ClientProvidedPort intfce) {
		super("ClientComponent", intfce);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Like SQL Request
	 * 
	 * <pre>
	 * <code>SELECT [columns] FROM [table] WHERE [attr]=[value];</code>
	 * </pre>
	 * 
	 * if [attr] equals "*" return all values:
	 * 
	 * <pre>
	 * <code>SELECT [columns] FROM [table];</code>
	 * </pre>
	 * 
	 * @param table
	 * @param attr
	 * @param value
	 * @param columns
	 */
	@SuppressWarnings("unchecked")
	public void doRequest(String table, String attr, String value,
			List<String> columns) {
		if (this.password == null) {
			System.err.println("[ClientComponent{" + this.getName()
					+ "}] You must set your password first");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", this.getName());
		params.put("password", this.password);
		params.put("TABLE", table);
		params.put("GET_COLUMN", attr);
		params.put("VALUE", value);
		params.put("RETURN_COLUMNS", columns);
		List<String> res;
		System.out.println("[ClientComponent{" + this.getName()
				+ "}] Call service {" + "DBServiceRequest" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		res = (List<String>) this.configuration.callService("DBServiceRequest",
				params);
		System.out.println("Result: " + Arrays.toString(res.toArray()));
	}

	public boolean isConnected() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", this.getName());
		params.put("password", this.password);
		System.out.println("[ClientComponent{" + this.getName()
				+ "}] Call service {" + "ConnectionService" + "} with params "
				+ Arrays.toString(params.entrySet().toArray()));
		return (Boolean) this.configuration.callService("ConnectionService",
				params);
	}
}
