import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;


public class Accueil {

	public JFrame frame;
	private JTextField txtIci;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		frame.setBounds(100, 100, largeur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("DicoBomb",JLabel.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblTitle.setBackground(Color.WHITE);
		frame.getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblChoisissezUnPseudo = new JLabel("Choisissez un pseudo :");
		panel_2.add(lblChoisissezUnPseudo);
		lblChoisissezUnPseudo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtIci = new JTextField();
		txtIci.addFocusListener(new FocusListener() {
            public void focusLost(final FocusEvent pE) {}
            public void focusGained(final FocusEvent pE) {
            	txtIci.selectAll();
            }
        });
		frame.add(txtIci);
		frame.validate();

        txtIci.requestFocus();
        
		panel_2.add(txtIci);
		txtIci.setHorizontalAlignment(SwingConstants.CENTER);
		txtIci.setText("ici");
		txtIci.setBackground(Color.WHITE);
		txtIci.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIci.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
		panel_3.add(table, BorderLayout.CENTER);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtIci}));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.PINK);
		textArea.setForeground(Color.BLACK);
		textArea.setTabSize(12);
		textArea.setEditable(false);
		panel_1.add(textArea);
	}
}
