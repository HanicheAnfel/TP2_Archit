import java.sql.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EtudiantService serv=new EtudiantService();
		serv.setStudent_rep(new EtudiantRepository());
		serv.setUniversity_rep(new UniversiteRepository());
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			
		
		serv.ajoutBonus();
	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
