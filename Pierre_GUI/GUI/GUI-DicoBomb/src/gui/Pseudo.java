package gui;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.Icon;

public class Pseudo {

	private JFrame frmDicobombpseudo;
	private JTextField textField;
	private JTextField txtChoisissezUnPseudo;
	private JTextField txtEntrezLadresseDu;
	private JTextField textField_2;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pseudo window = new Pseudo();
					window.frmDicobombpseudo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pseudo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDicobombpseudo = new JFrame();
		frmDicobombpseudo.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmDicobombpseudo.setTitle("img/DicoBomb-Pseudo");
		frmDicobombpseudo.setBounds(100, 100, 428, 215);
		frmDicobombpseudo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDicobombpseudo.getContentPane().setLayout(null);
		ImageIcon logo = new ImageIcon("img/LogoDicoBomb.jpg");
		frmDicobombpseudo.setIconImage(logo.getImage());
		
		JButton btnFaisPter = new JButton("Fais p\u00E9ter!");
		btnFaisPter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFaisPter.setBounds(57, 109, 106, 25);
		btnFaisPter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//  TODO: Verifier adresse ? -> 
				//  TODO: Verifier pseudo ? -> peut-etre generer pseudo aléatoire
				//  TODO: Lancer Choix_Serveur.java


				try {
					
					Scanner sc = new Scanner(System.in);
				    int number;
				    String ipString = textField_2.getText();
				    String IPADDRESS_PATTERN = //Match adresse IP
				            "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

				    Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
				    Matcher matcher = pattern.matcher(ipString);
				            if (matcher.find()) {
				            	System.out.println("Connexion à " + ipString + " ...");
				            	//  TODO: demander pseudo aléatoire
				            }
				            frmDicobombpseudo.setVisible(false);
							new Choix_Serveur();

//				    do {
//				        System.out.println("Please enter a positive number!");
//				        while (!sc.hasNext(p)) {
//				            System.out.println("That's not a number!");
//				            sc.next(); // this is important!
//				        }
//				        number = sc.nextInt();
//				    } while (number <= 0);
//				    System.out.println("Thank you! Got " + number);
					
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		frmDicobombpseudo.getContentPane().add(btnFaisPter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnnuler.setBounds(236, 109, 97, 25);
		frmDicobombpseudo.getContentPane().add(btnAnnuler);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(235, 55, 160, 41);
		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		frmDicobombpseudo.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtChoisissezUnPseudo = new JTextField();
		txtChoisissezUnPseudo.setBorder(null);
		txtChoisissezUnPseudo.setForeground(Color.BLACK);
		txtChoisissezUnPseudo.setBackground(Color.LIGHT_GRAY);
		txtChoisissezUnPseudo.setEditable(false);
		txtChoisissezUnPseudo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChoisissezUnPseudo.setText("Choisir un pseudo :");
		txtChoisissezUnPseudo.setBounds(71, 66, 152, 22);
		frmDicobombpseudo.getContentPane().add(txtChoisissezUnPseudo);
		txtChoisissezUnPseudo.setColumns(10);
		
		txtEntrezLadresseDu = new JTextField();
		txtEntrezLadresseDu.setBorder(null);
		txtEntrezLadresseDu.setText("Entrez l'adresse du serveur :");
		txtEntrezLadresseDu.setForeground(Color.BLACK);
		txtEntrezLadresseDu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEntrezLadresseDu.setEditable(false);
		txtEntrezLadresseDu.setColumns(10);
		txtEntrezLadresseDu.setBackground(Color.LIGHT_GRAY);
		txtEntrezLadresseDu.setBounds(12, 21, 217, 22);
		frmDicobombpseudo.getContentPane().add(txtEntrezLadresseDu);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(235, 10, 160, 41);
		textField_2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		frmDicobombpseudo.getContentPane().add(textField_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(291, 147, 107, 20);
		frmDicobombpseudo.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel Icon = new JLabel( new ImageIcon( "img/IconDicoBomb.jpg"));
		Icon.setBackground(new Color(192, 192, 192));
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(Icon, BorderLayout.NORTH);
		
		JLabel LogoCPE = new JLabel( new ImageIcon("img/LogoCPE.jpg"));
		LogoCPE.setBounds(0, 133, 50, 34);
		frmDicobombpseudo.getContentPane().add(LogoCPE);
		
		frmDicobombpseudo.getRootPane().setDefaultButton(btnFaisPter);
		
	}
}
