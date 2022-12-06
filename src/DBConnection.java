import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	String BDD = "etudiant";
	String url = "jdbc:mysql://localhost:3306/" + BDD;
	String user = "root";
	String passwd = "";
    private Connection cnxdb;
    private static DBConnection instance;


    private DBConnection() throws SQLException {
		cnxdb = DriverManager.getConnection(url, user,passwd);

	}


    public Connection getConn() {
		return cnxdb;
	}

    public static DBConnection getInstance() throws SQLException {
    	if(instance == null) {
    		instance = new DBConnection();
    	}
    	return instance;
    }




}
