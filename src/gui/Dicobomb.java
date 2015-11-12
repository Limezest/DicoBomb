package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import client.ClientRMIClient;
import client.ClientRMIServer;
import main.Game;
class DicobombFrame extends JFrame
{
	private String pseudo;
	public ClientRMIClient crmic;
	public ClientRMIServer crmis;
	private String ip_server;
	public static JList<String> listParties;
	private JButton creerPartie;
	public Jeu jeu;
	public static Map<String,String> parties;
	private New_partie new_partie; 
	public static Boolean ingame = true;
	DicobombFrame()
	{
		parties=new HashMap<String,String>();
		setPseudo();
		setServeur();
		newServer(1096);
		newClient(this.ip_server);
		try {
			this.crmic.newUser(this.pseudo);
			System.out.println("creation de l'utilisateur");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		initComponents();
	}
	private void setServeur() {
		ip_server = JOptionPane.showInputDialog(this,"Votre serveur ?","Serveur",JOptionPane.QUESTION_MESSAGE);
		if (ip_server==null)
		{
			ip_server="";
		}
		String IPADDRESS_PATTERN = //Match adresse IP
	            "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		Pattern pattern = Pattern.compile(IPADDRESS_PATTERN); 
		Matcher matcher = pattern.matcher(ip_server);

		if (ip_server.equals("") || !matcher.find() ) {
			setServeur();
		}
		
	}
	public String getPseudo()
	{
		return this.pseudo;
	}
    private void setPseudo() {
		pseudo = JOptionPane.showInputDialog(this,"Votre nom ?","Identification",JOptionPane.QUESTION_MESSAGE);
		if (pseudo==null) pseudo="";
		if (pseudo.equals("")) {
			pseudo="Guest";
			JOptionPane.showMessageDialog(null,"Tant pis!\n\nVotre nom est : "+pseudo);
		}

    }
	public void newClient(String ip) {
		crmic = new ClientRMIClient(ip);
	}
	public void newServer(Integer port) {
		try {
			SecurityManager security = System.getSecurityManager();
//			 System.setProperty("java.rmi.server.hostname", "192.168.43.238");
			if (security != null) {
				System.setSecurityManager(new java.lang.SecurityManager());
			}
			LocateRegistry.createRegistry(port);
			crmis = new ClientRMIServer();
			Naming.rebind("Dicobomb_client", crmis);
			System.out.println("Serveur pret.");
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e);
		}
	}
	private void initComponents()
	{
		
		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		ArrayList<Game> listGames;
		try {
			listGames = this.crmic.getGames();
			for(Game g : listGames)
			{
				model.addElement(g.getName());
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		setBounds(100, 100, 600, 500);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
		
        DicobombFrame.listParties = new JList<String>(model);
		listParties.setBounds(39, 45, 252, 579);
		getContentPane().add(listParties);
		

		
//		textField_1 = new JTextField();
//		textField_1.setBounds(349, 602, 388, 22);
//		frame.getContentPane().add(textField_1);
//		textField_1.setColumns(10);
		
		this.creerPartie = new JButton("Nouvelle partie");
		final JFrame frame = this;
		creerPartie.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
//		    		frame.setVisible(false);
//		    		Thread t = new Thread();
//		    		t.start();
		    		
		    		new_partie = new New_partie(frame,crmic,pseudo);
		    		
		    		
		    	} catch(Exception exception) {
		    		exception.printStackTrace();
		    	}
		    }		   
		});
		creerPartie.setBounds(87, 13, 154, 25);
		getContentPane().add(creerPartie);
		
        JLabel labelListPartie = new JLabel();
        labelListPartie.setText("Liste des parties");
        getContentPane().add(labelListPartie);
        final DicobombFrame t = this;
        
		DicobombFrame.listParties.addListSelectionListener( new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		    	  if(ingame)
		    	  {
		    	  	try {
		    	  		System.out.println((String)DicobombFrame.listParties.getSelectedValue() + " ");
						crmic.joinGame(pseudo, (String)DicobombFrame.listParties.getSelectedValue());
						jeu = new Jeu(t, (String)DicobombFrame.listParties.getSelectedValue());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
		    	  	ingame = false;
		    	  }
		            
		        }
		    });
		    setSize(345, 600);
//		    setVisible(true);
        
        
	}

	public void updateList()
	{
		final DefaultListModel<String> model = new DefaultListModel<String>();
		ArrayList<Game> listGames;
		try {
			listGames = crmic.getGames();
			for(Game g : listGames)
			{
				model.addElement(g.getName());
			}
			DicobombFrame.listParties.setModel(model);
			

		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
	
}
public class Dicobomb {
	
	public static void main(String[] args) {
		JFrame f = new DicobombFrame();
		f.setVisible(true);
	}

}
