package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import main.Game;
import main.GameManager;
import main.User;
import main.UserManager;

public class ServerRMI extends UnicastRemoteObject implements ServerRMInterface {
	private static final long serialVersionUID = 1L;

	protected ServerRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void newUser(String username) throws RemoteException {
		try {
			UserManager.addItem(username,getClientHost());
			ServerRMIClient.addClient(getClientHost());
		}catch(Exception e){}
		
	}

	public void newGame(String gamename, String dico) throws RemoteException {
		GameManager.addItem(gamename, dico);
	}

	public void userQuitGame(String username, String gamename) throws RemoteException {
		GameManager.quitGame(username, gamename);
	}

	public ArrayList<Game> getGames() throws RemoteException {
		return GameManager.getItems();
	}

	public ArrayList<User> getUsers() throws RemoteException {
		return UserManager.getItems();
	}

	public void joinGame(String username, String gamename) throws RemoteException {
		GameManager.joinGame(username, gamename);
	}

	public void userExitGame(String username) throws RemoteException {
		UserManager.delItem(username);
	}

	public void nextPlayer(String gamename,String word) throws RemoteException {
		GameManager.nextPlayer(gamename,word);
	}

	public void startGame(String gamename) throws RemoteException {
		GameManager.startGame(gamename);
	}
}