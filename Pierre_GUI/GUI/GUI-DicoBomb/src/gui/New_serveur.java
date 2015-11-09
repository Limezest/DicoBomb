package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;


public class New_serveur implements Runnable {

	private JFrame frmNouvellePartie;
	private JTextField txtEntrezUnNom;
	private JTextField textField_2;
	private JTextField txtChoisissezLeMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_serveur window = new New_serveur();
					window.frmNouvellePartie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public New_serveur() {
		initialize();
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
		button_1.setBounds(46, 148, 106, 25);
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
		JComboBox comboBox = new JComboBox(sListe);
		comboBox.setBounds(245, 88, 150, 25);
		frmNouvellePartie.getContentPane().add(comboBox);
		
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

	@Override
	public void run() {
		System.out.println("new partie");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_serveur window = new New_serveur();
					window.frmNouvellePartie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
