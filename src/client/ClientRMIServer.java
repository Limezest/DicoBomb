package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import com.sun.security.ntlm.Client;

import server.ServerRMIClient;

public class ClientRMIServer extends UnicastRemoteObject implements ClientRMInterface{
	private static final long serialVersionUID = 1L;

	protected ClientRMIServer() throws RemoteException {
		super();
	}

	@Override
	public void newPattern(String word) throws RemoteException {
		System.out.println("Le pattern est :"+word);
	}

	@Override
	public void changeCurrentUser(String username) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Le joueur est :"+username);	
	}

	public void userJoinGame(String username) throws RemoteException{
		System.out.println("Un joueur a rejoint la partie: "+username);
	}
	public void userQuitGame(String username) throws RemoteException{
		System.out.println("Un joueur a quiter la partie: "+username);
	}
	public void startGame(String username) throws RemoteException{
		System.out.println("Lancement de la partie, on commence avec :"+username);
		cmdLineInterface();
	}
	public void nextPlayer(String message) throws RemoteException{
		System.out.println("C'est au tour de :"+message.split(",")[0]+" avec le pattern :"+message.split(",")[1]);
		cmdLineInterface();
	}
	public void wordNotExist() throws RemoteException{
		System.out.println("Mauvais mot, essaye encore");
		cmdLineInterface();
	}
	public String inputKeyboard(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public void cmdLineInterface() throws RemoteException{
		client.Client.crmic.nextPlayer("Partie1", inputKeyboard());
	}
}
