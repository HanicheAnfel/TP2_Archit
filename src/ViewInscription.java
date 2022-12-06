

	import javax.swing.JOptionPane;
	import java.awt.Component;
	import javax.swing.JLabel;
	import java.awt.Container;
	import java.awt.Image;

	import javax.swing.border.Border;
	import javax.swing.border.EmptyBorder;

	import java.awt.LayoutManager;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	import javax.swing.JPanel;
	import javax.swing.JFrame;
	public class ViewInscription extends JFrame {

	    private JFrame Jframe;
	    private JPanel Panel;
	    private JTextField Matricule;
	    private JTextField Nom;
	    private JTextField Prenom;
	    private JTextField Email;
	    private JPasswordField Pwd;
	    private JTextField UnivId;
	    private JButton valider;
	    private JButton annuler;


	    private void Create() { 

	    	// Frame
	        this.Jframe = new JFrame();
	        Jframe.setBounds(400, 400, 500, 350);
	        Jframe.setResizable(false);
	        Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Jframe.getContentPane().setLayout(null);

	        // Container(panel)
	        this.Panel = new JPanel();

	        Jframe.setContentPane(this.Panel);
	        Panel.setLayout(null);

	        // lablel text Matricule
	        final JLabel LabMatricule = new JLabel("Matricule");
	        LabMatricule.setBounds(30, 33, 68, 17);
	        this.Panel.add(LabMatricule);
	        this.Matricule = new JTextField("");
	        Matricule.setBounds(184, 27, 250, 25);
	        Matricule.setColumns(10);
	        this.Panel.add(Matricule);


	     // lablel text Nom
	        final JLabel LabNom = new JLabel("Nom");
	        LabNom.setBounds(30, 60, 46, 14);
	        this.Panel.add(LabNom);
	        this.Nom = new JTextField("");
	        Nom.setBounds(184, 54, 250, 25);
	        Nom.setColumns(10);
	        this.Panel.add(Nom);

	     // lablel text prenom
	        final JLabel LabPrenom = new JLabel("Prénom");
	        LabPrenom.setBounds(30, 91, 46, 14);
	        this.Panel.add(LabPrenom);
	        this.Prenom = new JTextField("");
	        Prenom.setBounds(184, 85, 250, 25);
	        Prenom.setColumns(10);
	        this.Panel.add(Prenom);

	     // lablel text Email
	        final JLabel LabEmail = new JLabel("Email");
	        LabEmail.setBounds(30, 126, 46, 14);
	        this.Panel.add(LabEmail);
	        this.Email = new JTextField("");
	        Email.setColumns(10);
	        Email.setBounds(184, 120, 250, 25);
	        this.Panel.add(Email);


	     // lablel text Mot de passe
	        final JLabel LabPwd = new JLabel("Mot de passe");
	        LabPwd.setBounds(30, 165, 90, 14);
	        this.Panel.add(LabPwd);
	        this.Pwd = new JPasswordField("");
	        Pwd.setColumns(10);
	        Pwd.setEchoChar('*');
	        Pwd.setBounds(184, 159, 250, 25);
	        this.Panel.add(Pwd);

	     // lablel text UnivId
	        final JLabel LabId_Univ = new JLabel("Identifiant université");
	        LabId_Univ.setBounds(30, 200, 125, 14);
	        this.Panel.add(LabId_Univ);
	        this.UnivId = new JTextField("");
	        UnivId.setColumns(10);
	        UnivId.setBounds(184, 194, 250, 25);
	        this.Panel.add(UnivId);


	     // Bouton valider

	        Image imgV = new ImageIcon("C:\\Users\\toshiba\\Desktop\\TPArchiGit\\TP2\\src\\valider.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

	        Icon iconV = new ImageIcon(imgV);
	        this.valider = new JButton("valider" ,iconV);
	        valider.setBounds(270, 250, 140, 40);
	        this.Panel.add(valider);

	     // Bouton annuler

	        Image imgA = new ImageIcon("C:\\Users\\toshiba\\Desktop\\TPArchiGit\\TP2\\src\\annuler.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

	        Icon iconA= new ImageIcon(imgA);
	        this.annuler = new JButton("Annuler",iconA);
	        annuler.setBounds(120, 250, 140, 40);
	        this.Panel.add(annuler); 

	    }

	    public String Get_Mat() {
	        return this.Matricule.getText();
	    }

	    public String Get_Name() {
	        return this.Nom.getText();
	    }

	    public String Get_Prenom() {
	        return this.Prenom.getText();
	    }

	    public String Get_email() {
	        return this.Email.getText();
	    }


		public String Get_pwd() {
	        return this.Pwd.getText();
	    }

	    public String Get_id_univ() {
	        return this.UnivId.getText();
	    }

	    public boolean champsValides() {
	        if (Get_Mat().isEmpty() || Get_Prenom().isEmpty() || Get_Name().isEmpty() || Get_email().isEmpty() || Get_pwd().isEmpty() || Get_id_univ().isEmpty()) {
	            this.DisplayErreur("Veuillez remplir tous les champs!");
	            return false;
	        }
	        if (!this.Email.getText().matches("^(.+)@(.+)$")) {
	            this.DisplayErreur("Email invalide !");
	            return false;
	        }
	        if (!this.Matricule.getText().matches("-?\\d+") || !this.UnivId.getText().matches("-?\\d+")) {
	            this.DisplayErreur("Le matricule et id université doivent être de format numériques! ");
	            return false;
	        }
	        return true;
	    }


	    public void DisplayForm() { 
	        this.Create();
	        this.Jframe.setVisible(true);
	    }

	    public void addValiderListener(ActionListener listenForCalcButton) {
	    	valider.addActionListener(listenForCalcButton);
	    }

	    public void addAnnulerListener(ActionListener listenForCalcButton) {
	    	annuler.addActionListener(listenForCalcButton);
	    }
	    public void Annuler_Inscription() {
	        this.Jframe.dispose();
	    }

	    public void Reset_Champs() {
	        this.Matricule.setText("");
	        this.Nom.setText("");
	        this.Prenom.setText("");
	        this.Email.setText("");
	        this.Pwd.setText("");
	        this.UnivId.setText("");
	    }


	    public void DisplayDialog(final String msg) {
	        JOptionPane.showMessageDialog(this, msg);
	    }

	    public void DisplayErreur(final String msg) {
	        JOptionPane.showMessageDialog(this, msg, "Erreur", 0);
	    }


	}

}
