package gui;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import main.Dictionnary;
import main.Game;
import main.User;

import java.awt.Color;

public class Jeu extends JFrame {
	private DicobombFrame parent;
	private JLabel pattern;
	private JTextField word;
	private ArrayList<String> players;
	final static int[][] position_joueur={{300, 0, 90, 90},{461, 263, 90, 90},{508, 448, 90, 90},{461, 629, 90, 90},{290, 705, 90, 90},
			{114, 629, 90, 90},{72, 448, 90, 90},{114, 263, 90, 90}};
	/**
	 * Create the application.
	 */
	private String namePartie;
	public Jeu(DicobombFrame p, String partie) {
		parent = p;
		this.namePartie = partie;
		players = getUserInGames();
		
		System.out.println(players);
		initialize();
		this.setVisible(true);
	}
	private ArrayList<String> getUserInGames()
	{
		String itemName;
		try {
			for (Game item : parent.crmic.getGames()) {
				itemName = item.getName();
				if (itemName.compareTo(this.namePartie) == 0) {
					return item.getUsersInGame();
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */	
	private void initialize() {
		this.setTitle("DicoBomb");//On donne un titre à l'application
		setSize(1280,720); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setLayout(new BorderLayout());
//		this.getContentPane().setLayout(mgr);
		
		BorderLayout bl = new BorderLayout();
		bl.setHgap(50);
		JPanel conteneur_nord = new JPanel();
		conteneur_nord.setLayout(bl);
		JPanel conteneur_est = new JPanel();
		conteneur_est.setLayout(new BorderLayout());
		conteneur_est.setPreferredSize(new Dimension(600,360));
		conteneur_est.add(new JTextField());
		
		JPanel conteneur_partie = new JPanel();
		conteneur_partie.setLayout(null);
		
		
		
		JLabel avatar_player = new JLabel( new ImageIcon( "img/Benoit.jpg"));
		
//		JPanel panel_joueur = new JPanel();
//		panel_joueur.setBounds(300, 0, 90, 90);
//		panel_joueur.setLayout(new BoxLayout(panel_joueur, BoxLayout.PAGE_AXIS));
		int i = 0;
		for(String player : this.players) {
//			String cle = entry.getKey();
//			String valeur = entry.getValue();
			JLabel textField = new JLabel(player);
			JPanel panel_joueur = new JPanel();
			panel_joueur.setBounds(position_joueur[i][0],position_joueur[i][1], position_joueur[i][2], position_joueur[i][3]);
			panel_joueur.setLayout(new BoxLayout(panel_joueur, BoxLayout.PAGE_AXIS));

			textField.setBounds(position_joueur[i][0],position_joueur[i][1], position_joueur[i][2], position_joueur[i][3]);
			panel_joueur.add(textField);
			panel_joueur.add(avatar_player);
			conteneur_partie.add(panel_joueur);
		    i++;
		    
		}
//		panel_joueur.add(textField);
//		panel_joueur.add(avatar_player);
//		conteneur_partie.add(panel_joueur);
		JPanel conteneur_nord_centre = new JPanel();
		conteneur_nord_centre.setBorder(null);
		conteneur_nord_centre.setLayout(new BorderLayout());
		JPanel conteneur_nord_west = new JPanel();
		conteneur_nord_west.setBorder(null);
		conteneur_nord_west.setLayout(new BorderLayout());
		
		conteneur_nord.add(conteneur_nord_centre,BorderLayout.NORTH);
		conteneur_nord.add(conteneur_nord_west,BorderLayout.WEST);
		this.pattern = new JLabel("RPE");
		pattern.setFont(new Font("Tahoma", Font.BOLD, 16));
		pattern.setBorder(null);
		pattern.setPreferredSize(new Dimension(90, 50));
		this.word = new JTextField();
		word.setPreferredSize(new Dimension(90, 50));
		conteneur_nord_centre.add(pattern,BorderLayout.CENTER);
		conteneur_nord_west.add(word,BorderLayout.SOUTH);
		getContentPane().add(conteneur_nord, BorderLayout.NORTH);
		getContentPane().add(conteneur_est, BorderLayout.EAST);
		getContentPane().add(conteneur_partie, BorderLayout.CENTER);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Jeu window = new Jeu(new DicobombFrame(), "partie");
		window.setVisible(true);
	}
}
