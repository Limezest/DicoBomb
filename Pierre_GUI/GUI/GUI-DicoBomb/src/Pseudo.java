import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Pseudo {

	private JFrame frmDicobombpseudo;
	private JTextField textField;
	private JTextField txtChoisissezUnPseudo;
	private JTextField txtEntrezLadresseDu;
	private JTextField textField_2;

	/**
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
		frmDicobombpseudo.setTitle("DicoBomb-Pseudo");
		frmDicobombpseudo.setBounds(100, 100, 428, 215);
		frmDicobombpseudo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDicobombpseudo.getContentPane().setLayout(null);
		
		JButton btnFaisPter = new JButton("Fais p\u00E9ter!");
		btnFaisPter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFaisPter.setBounds(46, 121, 106, 25);
		frmDicobombpseudo.getContentPane().add(btnFaisPter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnnuler.setBounds(225, 121, 97, 25);
		frmDicobombpseudo.getContentPane().add(btnAnnuler);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(235, 55, 160, 41);
		frmDicobombpseudo.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtChoisissezUnPseudo = new JTextField();
		txtChoisissezUnPseudo.setBorder(null);
		txtChoisissezUnPseudo.setForeground(Color.BLACK);
		txtChoisissezUnPseudo.setBackground(Color.LIGHT_GRAY);
		txtChoisissezUnPseudo.setEditable(false);
		txtChoisissezUnPseudo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChoisissezUnPseudo.setText("Choisissez un pseudo :");
		txtChoisissezUnPseudo.setBounds(47, 66, 182, 22);
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
		frmDicobombpseudo.getContentPane().add(textField_2);
	}
}
