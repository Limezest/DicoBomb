import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Toolkit;

import javax.swing.JTextPane;

public class Jeu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu window = new Jeu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jeu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		frame.setBounds(100, 100, 1181, 1125);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Envoyer du SEL");
		button.setBounds(256, 473, 178, 29);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(button);
		
		textField = new JTextField();
		textField.setBounds(795, 998, 267, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(704, 43, 433, 942);
		panel_1.add(textPane);
		
		JButton btnQuitterLaPartie = new JButton("Quitter la partie");
		btnQuitterLaPartie.setBounds(994, 13, 143, 25);
		panel_1.add(btnQuitterLaPartie);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(290, 192, 90, 90);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(461, 263, 90, 90);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(508, 448, 90, 90);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(461, 629, 90, 90);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(290, 705, 90, 90);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(114, 629, 90, 90);
		panel_1.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(72, 448, 90, 90);
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(114, 263, 90, 90);
		panel_1.add(panel_9);
		
		
		JLabel image2 = new JLabel( new ImageIcon( "Benoit.jpg"));
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(image2);
		
		JLabel image3 = new JLabel( new ImageIcon( "Cyril.jpg"));
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(image3);
		
		JLabel image4 = new JLabel( new ImageIcon( "Lens.jpg"));
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(image4);
		
		JLabel image5 = new JLabel( new ImageIcon( "Pierre.jpg"));
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.add(image5);
		
		JLabel image6 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.add(image6);
		
		JLabel image7 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_7.setLayout(new BorderLayout(0, 0));
		panel_7.add(image7);
		
		JLabel image8 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_8.setLayout(new BorderLayout(0, 0));
		panel_8.add(image8);
		
		JLabel image9 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_9.setLayout(new BorderLayout(0, 0));
		panel_9.add(image9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(135, 366, 45, 45);
		panel_1.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(313, 295, 45, 45);
		panel_1.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(485, 366, 45, 45);
		panel_1.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(96, 551, 45, 45);
		panel_1.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(135, 732, 45, 45);
		panel_1.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(313, 808, 45, 45);
		panel_1.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(485, 732, 45, 45);
		panel_1.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(532, 551, 45, 45);
		panel_1.add(panel_17);
		
		JLabel image10 = new JLabel( new ImageIcon( "Bombe.jpg"));
		panel_10.setLayout(new BorderLayout(0, 0));
		panel_10.add(image10);
	}
}
