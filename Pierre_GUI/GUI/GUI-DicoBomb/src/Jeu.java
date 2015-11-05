import java.awt.EventQueue;

import javax.imageio.ImageIO;
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
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import java.awt.Color;

public class Jeu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField lettres;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu window = new Jeu();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
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
		frame.setBounds(100, 100, 1181, 1060);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(704, 956, 433, 46);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(248, 248, 255));
		textPane.setBounds(704, 43, 433, 913);
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
		
		JLabel image8 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_8.setLayout(new BorderLayout(0, 0));
		panel_8.add(image8);
		
		JLabel image9 = new JLabel( new ImageIcon( "Anonyme.jpg"));
		panel_9.setLayout(new BorderLayout(0, 0));
		panel_9.add(image9);		
		
		textField_1 = new JTextField("HerBenoit");
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setBorder(null);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setBounds(276, 171, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_2.setBorder(null);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(104, 240, 116, 22);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_3.setBorder(null);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(59, 426, 116, 22);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setBorder(null);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(106, 607, 116, 22);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_5.setBorder(null);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(276, 684, 116, 22);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_6.setBorder(null);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(446, 607, 116, 22);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_7.setBorder(null);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(495, 426, 116, 22);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_8.setBorder(null);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(446, 240, 116, 22);
		panel_1.add(textField_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(124, 353, 60, 60);
		panel_1.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(310, 281, 60, 60);
		panel_1.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(471, 353, 60, 60);
		panel_1.add(panel_12);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(518, 536, 60, 60);
		panel_1.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(471, 719, 60, 60);
		panel_1.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(310, 796, 60, 60);
		panel_1.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(135, 719, 60, 60);
		panel_1.add(panel_17);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(82, 536, 60, 60);
		panel_1.add(panel_13);
		
		JLabel image12 = new JLabel( new ImageIcon( "Bombe.jpg"));
		panel_12.setLayout(new BorderLayout(0, 0));
		panel_12.add(image12);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(207, 371, 250, 250);
		panel_18.setVisible(false);
		panel_1.add(panel_18);
		
		Random rand = new Random();
		String numPhoto =Integer.toString((int) (rand.nextInt(3-1+1)+1));
		
		JLabel image18 = new JLabel( new ImageIcon( "sel".concat(numPhoto).concat(".jpg")));
		panel_18.setLayout(new BorderLayout(0, 0));
		panel_18.add(image18);
		
		JButton button = new JButton("Envoyer du SEL");
		button.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
		    		String numPhoto =Integer.toString((int) (rand.nextInt(5-1+1)+1));
					image18.setIcon( new ImageIcon(ImageIO.read( new File("sel".concat(numPhoto).concat(".jpg")) ) ) );
					panel_18.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }		   
		});
		button.setBounds(256, 947, 178, 29);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(button);
		
		lettres = new JTextField("RPE");
		lettres.setHorizontalAlignment(SwingConstants.CENTER);
		lettres.setFont(new Font("Tahoma", Font.BOLD, 65));
		lettres.setEditable(false);
		lettres.setColumns(10);
		lettres.setBorder(null);
		lettres.setBounds(145, 63, 374, 67);
		panel_1.add(lettres);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_9.setColumns(10);
		textField_9.setBounds(129, 888, 433, 46);
		panel_1.add(textField_9);
		
	}
}
