package main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;



public class ClientCmndLine {
	private GameManagerInterface gmi ;
	private UserManagerInterface umi ;
	public ClientCmndLine()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("entrer votre pseudo :");
		String word=(keyboard.nextLine());
		keyboard.close();
		System.out.println("Hi, "+word+"!  ");
	}
    //permet à l'utilisateur d'entrer l'adresse du serveur
    public void connect() {
    	String adress="127.0.0.1";
    	if (adress!=null) connect(adress);
    }

    //connection au serveur
    public void connect(String adress) {
    	adress="rmi://"+adress+"/GameManager";
    	
		
		try {
		    this.umi = (GameManagerInterface) Naming.lookup(adress);
			//System.out.println(mh);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		} 
		adress="rmi://"+adress+"/UserManager";
    	
		
		try {
		    this.gmi = (GameManagerInterface) Naming.lookup(adress);
			//System.out.println(mh);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		} 
		
		
		
		try {
//			gmi.messageHandler("user:newUser=benoit");
//			gmi.messageHandler("user:newUser=pierre");
//			gmi.messageHandler("user:newUser=lens");
//			gmi.messageHandler("user:newUser=cyril");
//			gmi.messageHandler("game:newGame=Partie1,Dico1");
//			gmi.messageHandler("game:joinGame=benoit,Partie1");
//			gmi.messageHandler("game:joinGame=pierre,Partie1");
//			gmi.messageHandler("game:joinGame=lens,Partie1");
//			gmi.messageHandler("game:joinGame=cyril,Partie1");
//			gmi.messageHandler("game:getList");
//			gmi.messageHandler("user:getList");
//			gmi.messageHandler("game:startGame=Partie1");
//			while (true) 
//			{
			this.gmi.joinGame("lens","Partie1");
//			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public static void main (String [] argv) {
			ClientCmndLine cl = new ClientCmndLine(); 
			cl.connect("127.0.0.1");
    }
}
