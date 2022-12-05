import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	   
		String BDD = "etudiant";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";
	    private Connection dbcnx;
	    private static DBConnection instance;

	   
	    public DBConnection() throws SQLException {
			dbcnx=DriverManager.getConnection(url, user,passwd);
		}

	    
	    public Connection getConn() {
			return dbcnx;
		}
	    public static DBConnection getInstance() throws SQLException {
	    	if(instance == null) {
	    		instance = new DBConnection();
	    	}
	    	return instance;
	    }


		
	
}
