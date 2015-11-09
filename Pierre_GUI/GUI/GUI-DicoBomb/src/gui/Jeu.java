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
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Jeu implements Runnable {

	private JFrame frmDicobomb;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInvit_2;
	private JTextField txtInvit_1;
	private JTextField textField_4;
	private JTextField txtInvit;
	private JTextField txtVempierre;
	private JTextField txtLensrocket;
	private JTextField txtNomercyril;
	private JTextField lettres;
	private JTextField textField_9;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Jeu window = new Jeu();
		window.frmDicobomb.setVisible(true);
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
		frmDicobomb = new JFrame();
		frmDicobomb.setTitle("DicoBomb");
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//		int hauteur = (int)tailleEcran.getHeight();
//		int largeur = (int)tailleEcran.getWidth();
		frmDicobomb.setBounds(950, -45, 1220, 900);
		frmDicobomb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDicobomb.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmDicobomb.getContentPane().add(panel, BorderLayout.EAST);
		

		ImageIcon logo = new ImageIcon("img/LogoDicoBomb.jpg");
		frmDicobomb.setIconImage(logo.getImage());
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		frmDicobomb.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		frmDicobomb.setLocationRelativeTo(null);
		frmDicobomb.setResizable(false);
		
		textField = new JTextField();
		textField.setBounds(745, 777, 433, 46);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(745, 43, 433, 733);
		textPane.setEditable(false);
		panel_1.add(textPane);
		
		final JButton btnQuitterLaPartie = new JButton("Quitter la partie");
		btnQuitterLaPartie.setBounds(1035, 13, 143, 25);
		btnQuitterLaPartie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane popup = new JOptionPane();
				@SuppressWarnings("static-access")
				int retour = popup.showConfirmDialog(btnQuitterLaPartie, "Êtes-vous sûr(e) ?",
														"Quitter la partie", JOptionPane.OK_CANCEL_OPTION);
				
				if (retour == JOptionPane.OK_OPTION) {
					// TODO: Appeler la fonction pour quitter la partie
				}
				
			}
		});
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
		
		
		JLabel image2 = new JLabel( new ImageIcon( "img/Benoit.jpg"));
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(image2);
		
		JLabel image3 = new JLabel( new ImageIcon( "img/Cyril.jpg"));
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(image3);
		
		JLabel image4 = new JLabel( new ImageIcon( "img/Lens.jpg"));
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(image4);
		
		JLabel image5 = new JLabel( new ImageIcon( "img/Pierre.jpg"));
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.add(image5);
		
		JLabel image6 = new JLabel( new ImageIcon( "img/Anonyme.jpg"));
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.add(image6);
		
		JLabel image8 = new JLabel( new ImageIcon( "img/Anonyme.jpg"));
		panel_8.setLayout(new BorderLayout(0, 0));
		panel_8.add(image8);
		
		JLabel image9 = new JLabel( new ImageIcon( "img/Anonyme.jpg"));
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
		
		txtInvit_2 = new JTextField();
		txtInvit_2.setText("Invit\u00E989");
		txtInvit_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtInvit_2.setBorder(null);
		txtInvit_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvit_2.setEditable(false);
		txtInvit_2.setColumns(10);
		txtInvit_2.setBounds(104, 240, 116, 22);
		panel_1.add(txtInvit_2);
		
		txtInvit_1 = new JTextField();
		txtInvit_1.setText("Invit\u00E948");
		txtInvit_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtInvit_1.setBorder(null);
		txtInvit_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvit_1.setEditable(false);
		txtInvit_1.setColumns(10);
		txtInvit_1.setBounds(59, 426, 116, 22);
		panel_1.add(txtInvit_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setBorder(null);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(92, 607, 116, 22);
		panel_1.add(textField_4);
		
		txtInvit = new JTextField();
		txtInvit.setText("Invit\u00E9158");
		txtInvit.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtInvit.setBorder(null);
		txtInvit.setHorizontalAlignment(SwingConstants.CENTER);
		txtInvit.setEditable(false);
		txtInvit.setColumns(10);
		txtInvit.setBounds(276, 684, 116, 22);
		panel_1.add(txtInvit);
		
		txtVempierre = new JTextField();
		txtVempierre.setText("VamPierre");
		txtVempierre.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtVempierre.setBorder(null);
		txtVempierre.setHorizontalAlignment(SwingConstants.CENTER);
		txtVempierre.setEditable(false);
		txtVempierre.setColumns(10);
		txtVempierre.setBounds(446, 607, 116, 22);
		panel_1.add(txtVempierre);
		
		txtLensrocket = new JTextField();
		txtLensrocket.setText("LensRocket");
		txtLensrocket.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtLensrocket.setBorder(null);
		txtLensrocket.setHorizontalAlignment(SwingConstants.CENTER);
		txtLensrocket.setEditable(false);
		txtLensrocket.setColumns(10);
		txtLensrocket.setBounds(495, 426, 116, 22);
		panel_1.add(txtLensrocket);
		
		txtNomercyril = new JTextField();
		txtNomercyril.setText("NoMerCyril");
		txtNomercyril.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNomercyril.setBorder(null);
		txtNomercyril.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomercyril.setEditable(false);
		txtNomercyril.setColumns(10);
		txtNomercyril.setBounds(446, 240, 116, 22);
		panel_1.add(txtNomercyril);
		
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
		
		JLabel image12 = new JLabel( new ImageIcon( "img/Bombe.jpg"));
		panel_12.setLayout(new BorderLayout(0, 0));
		panel_12.add(image12);
		
		final JPanel panel_18 = new JPanel();
		panel_18.setBounds(207, 371, 250, 250);
		panel_18.setVisible(false);
		panel_1.add(panel_18);

		final JLabel image18 = new JLabel();
		panel_18.setLayout(new BorderLayout(0, 0));
		panel_18.add(image18);
		
		JButton button = new JButton("Envoyer du SEL");
		button.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
		    		final Random rand = new Random();
		    		String numPhoto =Integer.toString((int) (rand.nextInt(5-1+1)+1));
					image18.setIcon( new ImageIcon(ImageIO.read( new File("img/sel".concat(numPhoto).concat(".jpg")) ) ) );
					panel_18.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }		   
		});
		button.setBounds(243, 634, 178, 29);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(button);
		
		lettres = new JTextField("RPE");
		lettres.setHorizontalAlignment(SwingConstants.CENTER);
		lettres.setFont(new Font("Tahoma", Font.BOLD, 65));
		lettres.setEditable(false);
		lettres.setColumns(10);
		lettres.setBorder(null);
		lettres.setBounds(147, 0, 374, 67);
		panel_1.add(lettres);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_9.setColumns(10);
		textField_9.setBounds(118, 90, 433, 46);
		textField_9.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String contenu = textField_9.getText();
					JOptionPane.showMessageDialog(null , "Mot : " + contenu);
					//  TODO: Appeler la fonction de vérification
				}
			}
		});
		panel_1.add(textField_9);
		
	}

	@Override
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu window = new Jeu();
					window.frmDicobomb.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}