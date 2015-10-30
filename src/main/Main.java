package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;



public class Main {
	
	public static void main(String[] args) {
		
    	SecurityManager security = System.getSecurityManager();
    	//System.setProperty("java.rmi.server.hostname","10.1.0.182");
    	
        if (security != null) {
        	System.setSecurityManager(new java.lang.SecurityManager());
        }
		
		try {
			LocateRegistry.createRegistry(1099);
			GameManager gm = new GameManager();
		    Naming.rebind("Dicobomb",gm);
		    //GameManager.startGame("Partie1");
		    
		    System.out.println("Serveur pret.");
		} catch (Exception e) {
		    System.out.println("Erreur serveur : " + e);
		}

//		mh.messageHandler("user:newUser=benoit");
//		mh.messageHandler("user:newUser=pierre");
//		mh.messageHandler("user:newUser=lens");
//		mh.messageHandler("user:newUser=cyril");
//		mh.messageHandler("game:newGame=Partie1,Dico1");
//		mh.messageHandler("game:joinGame=benoit,Partie1");
//		mh.messageHandler("game:joinGame=pierre,Partie1");
//		mh.messageHandler("game:joinGame=lens,Partie1");
//		mh.messageHandler("game:joinGame=cyril,Partie1");
//		mh.messageHandler("game:getList");
//		mh.messageHandler("user:getList");
//		mh.messageHandler("game:startGame=Partie1");
//		while (true) 
//		{
//			GameManager.nextPlayer("Partie1");
//		}
	}
}