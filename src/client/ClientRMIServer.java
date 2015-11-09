package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIServer extends UnicastRemoteObject implements ClientRMInterface {
	private static final long serialVersionUID = 1L;
	private Thread t;

	protected ClientRMIServer() throws RemoteException {
		super();
	}

	@Override
	public void newPattern(String word) throws RemoteException {
		System.out.println("Le pattern est :" + word);
	}

	@Override
	public void changeCurrentUser(String username) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Le joueur est :" + username);
	}

	public void userJoinGame(String username) throws RemoteException {
		System.out.println("Un joueur a rejoint la partie: " + username);
	}

	public void userQuitGame(String username) throws RemoteException {
		System.out.println("Un joueur a quiter la partie: " + username);
	}

	public void startGame(String message) throws RemoteException {
		System.out.println("Lancement de la partie, on commence avec :" + message.split(",")[0] + " avec le pattern :"
				+ message.split(",")[1]);
		if (Client.myusername.compareTo(message.split(",")[0]) == 0) {
			t = new Thread(new cmdLineClient());
			t.start();
		} else {
			System.out.println("Ce n'est à toi de jouer");
		}
	}

	public void nextPlayer(String message) throws RemoteException {
		System.out.println("C'est au tour de :" + message.split(",")[0] + " avec le pattern :" + message.split(",")[1]);
		if (Client.myusername.compareTo(message.split(",")[0]) == 0) {
			t = new Thread(new cmdLineClient());
			t.start();
		} else {
			System.out.println("Ce n'est à toi de jouer");
		}
	}

	public void wordNotExist(String message) throws RemoteException {
		System.out.println(message);
		t = new Thread(new cmdLineClient());
		t.start();

	}

	public void newLive(String message) throws RemoteException {
		System.out.println(message);
	}

	@Override
	public void timeElapsed(String message) throws RemoteException {
		System.out.println("Temps ecoulé - fin de la partie");
		
	}
}
