
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class EtudiantRepository implements Student_Interface {
	
	@Override
	public void add(Etudiant S, IJournal journal)throws SQLException
	{

		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT Into etudiant Values (" + S.getMatricule() + ",'" + S.getNom() + "','" + S.getPrenom() + "','" + S.getEmail() + "'," +S.getNbLivreMensuel_Autorise() + "," +S.getNbLivreEmprunte() + "," +S.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				journal.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + S.getMatricule());
			}else if (rs == 0){
				journal.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + S.getMatricule());
			}
		//connect.close();
	 }


	public boolean Exists(String mail, IJournal journal)throws SQLException	
	{
		DBConnection BD=  DBConnection.getInstance();
		Connection connect= BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "Select * From etudiant WHERE email='"+ mail+"'";
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			journal.outPut_Msg("logBD--- :email existe dans la BD  " + mail);
			//connect.close();
			return true;
			}
		journal.outPut_Msg("logBD--- : email n'existe pas " + mail);	
		//connect.close();
		return false;
	}
	
	public boolean Exists(int matricule, IJournal journal)throws SQLException
	{
		DBConnection BD= DBConnection.getInstance();
		Connection connect= BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "Select * From etudiant WHERE matricule="+ matricule;
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			journal.outPut_Msg("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + matricule);
			//connect.close();
			return true;
			}
		journal.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + matricule);	
		//connect.close();
		return false;
	}
	 @Override
	    public ArrayList<Etudiant> getEtudiants() throws SQLException {

	    	ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	    	DBConnection BD= DBConnection.getInstance();
			Connection connect= BD.getConn();

			Statement stmt = connect.createStatement();
			String sql = "SELECT * FROM etudiant";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Etudiant S = new Etudiant(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),null,rs.getInt(7));
				etudiants.add(S);
			}


			return etudiants;
	    }

}
