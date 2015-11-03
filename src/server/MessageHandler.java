package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MessageHandler extends UnicastRemoteObject implements MessageHandlerInterface {
	private static final long serialVersionUID = 1L;

	protected MessageHandler() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void newUser(String username) throws RemoteException {
		UserManager.addItem(username);
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

	public void nextPlayer(String username) throws RemoteException {
		GameManager.nextPlayer(username);
	}

	public void startGame(String gamename) throws RemoteException {
		GameManager.startGame(gamename);
	}
}