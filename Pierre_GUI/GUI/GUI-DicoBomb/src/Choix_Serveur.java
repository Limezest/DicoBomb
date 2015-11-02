import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.util.EventListener;


public class Choix_Serveur {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choix_Serveur window = new Choix_Serveur();
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
	public Choix_Serveur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 798, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] data = { "A", "B", "C", "D", "E", "F", "G", "H" };
		JList<String> list = new JList<String>(data);
		list.setBounds(39, 45, 252, 579);
		frame.getContentPane().add(list);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBounds(351, 24, 386, 568);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(349, 602, 388, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNouveauServeur = new JButton("Nouveau serveur");
		btnNouveauServeur.setBounds(83, 13, 146, 25);
		frame.getContentPane().add(btnNouveauServeur);
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		          JList list = (JList) listSelectionEvent.getSource();
		          int selections[] = list.getSelectedIndices();
		          Object selectionValues[] = list.getSelectedValues();
		            System.out.println(selections[0] + "/" + selectionValues[0] + " ");
		        }
		    };
		    list.addListSelectionListener(listSelectionListener);
		    frame.setSize(770, 630);
		    frame.setVisible(true);
		
	}
}
