package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
}
