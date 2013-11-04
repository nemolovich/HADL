package m1.server.database.generator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import m1.server.database.DatabaseManager;

/**
 * 
 * @author COUTABLE Guillaume, GOHIER Brian
 *
 */
public class ClassCreator
{
	public static final String END_NAME = "_TABLE";
	private static String PATH="./sql/dbStruct/";
	private static String FILE="config.cfg";
	private Properties properties=new Properties();
	private DatabaseManager dm=null;
	private List<EntityClass> entities=new ArrayList<EntityClass>();
	
	/**
	 * @return the entities
	 */
	public List<EntityClass> getEntities() {
		return entities;
	}

	public ClassCreator(DatabaseManager dm) {
		this.dm=dm;
		try {
			this.properties.load(new FileReader(ClassCreator.PATH+
					ClassCreator.FILE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Object key:this.properties.keySet()) {
			EntityClass ec=new EntityClass((String)key);
			Properties prop=new Properties();
			try {
				prop.load(new FileReader(ClassCreator.PATH+((String)key).toLowerCase()+
						".struct"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for(Object att:prop.keySet()) {
				ec.addAttribute((String)att, (String)prop.get(att));
			}
			if(this.dm.createTable(ec,true)) {
				final String[] attrs={"name","firstname","age","sexe","gl"};
				final Object[] values={"GOHIER","Brian",23,'M',true};
				if(!this.dm.addValues((String)key,attrs,values)) {
					System.err.println("Could not insert data");
				}
				this.entities.add(ec);
			}
		}
	}
	
}
