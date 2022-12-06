import java.sql.*;
import java.util.ArrayList;

public interface Student_Interface {
	public void add(Etudiant S, IJournal journal)throws SQLException;
	public boolean Exists(String mail, IJournal journal)throws SQLException;
	public boolean Exists(int matricule, IJournal journal)throws SQLException;
	ArrayList<Etudiant> getEtudiants() throws SQLException;
}
