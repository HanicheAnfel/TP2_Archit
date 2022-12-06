import java.awt.event.ActionListener;
public interface View_Inscription_Interface {
	

		public String Get_Mat();
		public String Get_Name();
		public String Get_Prenom();
		public String Get_email();
		public String Get_pwd();
		public String Get_id_univ();
		public boolean champsValides();
		public void DisplayForm();
		public void addValiderListener(ActionListener listenForCalcButton);
		public void addAnnulerListener(ActionListener listenForCalcButton);
		public void Annuler_Inscription();
		public void Reset_Champs();
		public void DisplayDialog(final String msg);
		public void DisplayErreur(final String msg);
	

}
