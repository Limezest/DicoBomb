package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import client.ClientRMIClient;
import main.Game;


public class New_partie  {

	private JFrame frmNouvellePartie;
	private JTextField txtEntrezUnNom;
	private JTextField textField_2;
	private JTextField txtChoisissezLeMode;
	private ClientRMIClient crmc;
	private String pseudo;
	private JComboBox<String> choixDico;
	private DicobombFrame parent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		New_partie window = new New_partie(new JFrame(), new ClientRMIClient(),"lens");
		window.frmNouvellePartie.setVisible(true);
	}
	public String getNompartie()
	{
		return this.textField_2.getText();
	}
	public JFrame getfrmNouvellePartie()
	{
		return this.frmNouvellePartie;
	}
	/**
	 * Create the application.
	 */
	public New_partie(JFrame f,ClientRMIClient crmi, String pseudo) {
		this.crmc = crmi;
		this.pseudo = pseudo;
		this.parent = (DicobombFrame) f;
		initialize();
		this.frmNouvellePartie.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouvellePartie = new JFrame();
		frmNouvellePartie.setTitle("Nouvelle partie!");
		frmNouvellePartie.setBounds(100, 100, 446, 236);
		frmNouvellePartie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouvellePartie.getContentPane().setLayout(null);
		
		JButton button = new JButton("Annuler");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(225, 148, 97, 25);
		frmNouvellePartie.getContentPane().add(button);
		
		JButton button_1 = new JButton("Fais p\u00E9ter!");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(46, 148, 120, 25);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomPartie = textField_2.getText();
				String dico = (String) choixDico.getSelectedItem();
				System.out.println("nompartie " + nomPartie);
				if (nomPartie == null)  {
					System.out.println("non");
				} else {
					//  TODO: Fonction pour ajouter une partie
					
					try {
						System.out.println("creer nouvelle partie");
						
						DicobombFrame.parties.put(nomPartie, dico);
						crmc.newGame(nomPartie, dico, pseudo);
						crmc.joinGame(pseudo, nomPartie);
						ArrayList<Game> listGames = crmc.getGames();
		    			for(Game g : listGames)
		    			{
		    				System.out.println(g.getName());
		    			}
		    			parent.updateList();
		    			frmNouvellePartie.setVisible(false);
		    			parent.jeu = new Jeu(parent, nomPartie);
//						Thread tJeu = new Thread(new Jeu());
//						tJeu.start();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		frmNouvellePartie.getContentPane().add(button_1);
		
		txtEntrezUnNom = new JTextField();
		txtEntrezUnNom.setBorder(null);
		txtEntrezUnNom.setText("Entrez un nom de partie : ");
		txtEntrezUnNom.setForeground(Color.BLACK);
		txtEntrezUnNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEntrezUnNom.setEditable(false);
		txtEntrezUnNom.setColumns(10);
		txtEntrezUnNom.setBackground(new Color(238, 238, 238));
		txtEntrezUnNom.setBounds(30, 24, 199, 22);
		frmNouvellePartie.getContentPane().add(txtEntrezUnNom);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(235, 13, 160, 41);
		frmNouvellePartie.getContentPane().add(textField_2);
		
		String[] sListe = {"Français", "Anglais"};
		choixDico = new JComboBox<String>(sListe);
		choixDico.setBounds(245, 88, 150, 25);
		frmNouvellePartie.getContentPane().add(choixDico);
		
		txtChoisissezLeMode = new JTextField();
		txtChoisissezLeMode.setBorder(null);
		txtChoisissezLeMode.setText("Choisir le mode de jeu : ");
		txtChoisissezLeMode.setForeground(Color.BLACK);
		txtChoisissezLeMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChoisissezLeMode.setEditable(false);
		txtChoisissezLeMode.setColumns(10);
		txtChoisissezLeMode.setBackground(new Color(238, 238, 238));
		txtChoisissezLeMode.setBounds(30, 88, 214, 22);
		frmNouvellePartie.getContentPane().add(txtChoisissezLeMode);
	}

}
