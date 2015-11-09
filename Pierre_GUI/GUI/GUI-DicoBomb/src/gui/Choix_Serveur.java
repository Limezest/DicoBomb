package gui;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;


public class Choix_Serveur implements Runnable {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		final DefaultListModel model = new DefaultListModel();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 798, 682);
		frame.setResizable(false);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList<String> list = new JList(model);
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
		btnNouveauServeur.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
		    		frame.setVisible(false);
		    		new New_serveur();
		    	} catch(Exception exception) {
		    		exception.printStackTrace();
		    	}
		    }		   
		});
		btnNouveauServeur.setBounds(87, 13, 154, 25);
		frame.getContentPane().add(btnNouveauServeur);
		
//		JButton btnActualiser = new JButton("Actualiser");
//		btnActualiser.addActionListener( new ActionListener()
//		{
//		    public void actionPerformed(ActionEvent e)
//		    {
//				model.addElement("B");
//				JList<String> list = new JList(model);
//		    }		   
//		});
//		btnActualiser.setBounds(194, 13, 97, 25);
//		frame.getContentPane().add(btnActualiser);
		
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

	@Override
	public void run() {
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
}
