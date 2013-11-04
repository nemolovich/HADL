package m1.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import m1.server.database.generator.ClassCreator;
import m1.server.database.generator.EntityClass;
import m2.element.Component;

public class DatabaseManager extends Component {

	private String dbHost="localhost";
	private int dbPort=1527;
	private String dbName="server_db";
	private boolean create=true;
	private String dbUser="root";
	private String dbPassword="root";
	private String dbURL=null;
	private Connection connexion=null;
	private Statement stmt=null;

	public DatabaseManager(String name, DBProvidedPort port) {
		super(name, port);
	}
	
	public boolean connect() {
		boolean connected=false;
		try {
			this.dbURL="jdbc:derby://"+this.dbHost+":"+this.dbPort+"/"+this.dbName+
					(this.create?";create=true":"");
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			//	Get a connection
			this.connexion = DriverManager.getConnection(this.dbURL,
					this.dbUser, this.dbPassword);
	    	this.stmt=this.connexion.createStatement();
			connected=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connected;
	}
	
	public boolean close() {
		boolean closed=false;
		try {
			this.stmt.close();
			this.connexion.close();
			closed=this.connexion.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return closed;
	}
	
	public boolean deleteTable(String tableName) {
	    boolean deleted=false;
	    try {
	    	this.stmt.executeUpdate("DROP TABLE ROOT."+tableName+ClassCreator.END_NAME);
			deleted=true;
			System.out.println("Table \""+tableName.toUpperCase()+
					ClassCreator.END_NAME+"\" deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return deleted;
	}
	
	public boolean createTable(EntityClass ec, boolean force) {
	    boolean created=false;
	    String className=ec.getName();
	    Map<String, String> attrs=ec.getAttributes();
		boolean exists=this.tableExists(className);
		if(exists) {
			System.err.println("The table \""+className.toUpperCase()+
					ClassCreator.END_NAME+"\" already exists");
			if(force) {
				this.deleteTable(className);
			}
			else {
				return false;
			}
		}
	    String query="CREATE TABLE ROOT."+className.toUpperCase()+
	    		ClassCreator.END_NAME+" (";
	    if(attrs.size()>0) {
	    	boolean first=true;
		    for(String key:attrs.keySet()) {
		    	boolean isId=false;
		    	if(ec.getId().equals(key)&&attrs.get(key).equalsIgnoreCase("INTEGER")) {
		    		isId=true;
		    	}
		    	if(!first) {
		    		query+=",\n";
		    	}
		    	else {
		    		first=false;
		    	}
		    	query+=key+" "+attrs.get(key);
		    	String constraint=ec.getConstraint(attrs.get(key));
		    	if(isId) {
		    		query+=" PRIMARY KEY GENERATED ALWAYS AS IDENTITY"+
			    			"(START WITH 1, INCREMENT BY 1)";
		    	}
		    	else if(constraint!=null) {
		    		query+=" "+constraint;
		    	}
		    }
	    }
	    query+=")";
	    try {
	    	this.stmt.executeUpdate(query);
			created=true;
			System.out.println("Table \""+className.toUpperCase()+
					ClassCreator.END_NAME+"\" created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return created;
	}
	
	public boolean tableExists(String tableName) {
		try {
		    ResultSet result = stmt.executeQuery("SELECT * FROM "+tableName+
		    		ClassCreator.END_NAME);
		    return result!=null;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public ResultSet request(String request) {
		try {
		    ResultSet result = this.stmt.executeQuery(request);
		    return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addValues(String tableName, String[] attributes, Object[] values) {

		boolean inserted=false;
		boolean exists=this.tableExists(tableName);
		if(!exists) {
			System.err.println("The table \""+tableName.toUpperCase()+
					ClassCreator.END_NAME+"\" does not exist");
			return false;
		}
		String attrs="";
    	boolean first=true;
		for(String attr:attributes) {
	    	if(!first) {
	    		attrs+=", ";
	    	}
	    	else {
	    		first=false;
	    	}
			attrs+="\""+attr+"\"";
		}
	    String query="INSERT INTO ROOT."+tableName.toUpperCase()+
	    		ClassCreator.END_NAME+"("+attrs.toUpperCase()+") VALUES (";
	    if(values.length>0) {
			first=true;
		    for(Object value:values) {
		    	if(!first) {
		    		query+=",\n";
		    	}
		    	else {
		    		first=false;
		    	}
		    	if(value instanceof String || value instanceof Character) {
		    		query+="'"+value+"'";
		    	}
		    	else {
		    		query+=value;
		    	}
		    }
	    }
	    query+=")";
	    try {
	    	this.stmt.executeUpdate(query);
	    	inserted=true;
			System.out.println("Data inserted in table \""+tableName.toUpperCase()+
					ClassCreator.END_NAME+"\"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return inserted;
	}
	
	public void displayResult(ResultSet result) {
		try {
            ResultSetMetaData rsmd = result.getMetaData();
            int numberCols = rsmd.getColumnCount();
            System.out.println("Data from table \""+rsmd.getTableName(1)+"\":");
			for(int i=1;i<=numberCols;i++) {
				System.out.printf("%20s",rsmd.getColumnName(i)+" | ");
			}
			System.out.println();
			for(int i=1;i<=numberCols;i++) {
				System.out.printf("%20s","----------------- | ");
			}
			System.out.println();
			while (result.next()) {
				for(int i=1;i<=numberCols;i++) {
					System.out.printf("%20s",result.getObject(i)+" | ");
				}
				System.out.println("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String... args) {
		DatabaseManager dm=new DatabaseManager("DBManager", new DBProvidedPort("dbPort"));
		if(!dm.connect()) {
			return;
		}
//		dm.request("SELECT * FROM ROOT.TEST");
		ClassCreator cc = new ClassCreator(dm);
		for(EntityClass ec:cc.getEntities()) {
			ResultSet result=dm.request("SELECT * FROM ROOT."+ec.getName()+
					ClassCreator.END_NAME);
			dm.displayResult(result);
		}
		dm.close();
	}

}
