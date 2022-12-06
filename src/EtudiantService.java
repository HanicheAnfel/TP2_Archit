import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	
	private Student_Interface Student_rep;
	private Univ_Interface University_rep;
	private IJournal journal;
	
		public void setStudent_rep(Student_Interface Student_rep) {
			this.Student_rep=Student_rep;
		}
		public  Student_Interface getStudent_rep() {
			 return this.Student_rep;
		}
		public void setUniversity_rep(Univ_Interface University_rep) {
			this.University_rep=University_rep;
		}
		public void setJournal( IJournal journal) {
			this.journal=journal;
		}
		public IJournal getJournal( IJournal journal) {
			 return  this.journal;
		}
	
	
	
	boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException	
	{
		Student_Interface Student_rep= new EtudiantRepository();
		Univ_Interface University_rep= new UniversiteRepository();
	    Etudiant student = new Etudiant(matricule, nom, prénom, email,pwd,id_universite);
	    Universite univ=University_rep.GetById(id_universite,journal);
	    
	    journal.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+matricule);
	    
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          student.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 student.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 Student_rep.add(student,journal);
		 journal.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	public void ajoutBonus() throws SQLException {
		ArrayList<Etudiant> etudiants = Student_rep.getEtudiants();

		for(Etudiant S : etudiants) {
			Universite univ = University_rep.GetById(S.getId_universite(), journal);
			S.Bonus(univ);
		}
	}
	
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
