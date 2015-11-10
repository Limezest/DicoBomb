package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIServer extends UnicastRemoteObject implements ClientRMInterface {
	private static final long serialVersionUID = 1L;
	private Thread t;

	protected ClientRMIServer() throws RemoteException {
		super();
	}
	public void userJoinGame(String username) throws RemoteException {
		System.out.println("Un joueur a rejoint la partie: " + username);
	}

	public void userQuitGame(String username) throws RemoteException {
		System.out.println("Un joueur a quiter la partie: " + username);
	}

	public void startGame(String message) throws RemoteException {
		// 0 : username ; 1 : pattern
		String username = message.split(",")[0];
		String pattern= message.split(",")[1];
		System.out.println("Lancement de la partie, on commence avec :" + username + " avec le pattern :"+ pattern);
		if (Client.myusername.compareTo(username) == 0) {
			t = new Thread(new cmdLineClient());
			t.start();
		} else {
			System.out.println("Ce n'est pas à toi de jouer");
		}
	}

	public void nextPlayer(String message) throws RemoteException {
		// 0 : username ; 1 : pattern
		String username = message.split(",")[0];
		String pattern= message.split(",")[1];
		System.out.println("C'est au tour de :" +username+ " avec le pattern :" +pattern);
		if (Client.myusername.compareTo(username) == 0) {
			t = new Thread(new cmdLineClient());
			t.start();
		} else {
			System.out.println("Ce n'est pas à toi de jouer");
		}
	}

	public void wordNotExist(String message) throws RemoteException {
		System.out.println(message);
		t = new Thread(new cmdLineClient());
		t.start();
	}

	public void newLive(String live) throws RemoteException {
		System.out.println("Vous avez une nouvelle vie, vous en avez :"+live);
	}

	public void timeElapsed(String message) throws RemoteException {
		System.out.println("Temps ecoulé - fin de la partie | "+message+" a perdu");
		
	}

	public void hoteQuit(String message) throws RemoteException {
		System.out.println("Changement d'hote : "+message+" est le nouvel hote");
		
	}

	public void receiveMessage(String message) throws RemoteException {
		// 0 : sender ; 1 : message
		String sender = message.split(",")[0];
		String string= message.split(",")[1];
		System.out.println("message de "+sender+" :"+string);
	}
}
