package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.Game;
import main.User;

public interface ServerRMInterface extends Remote {
	public void userExitGame(String username) throws RemoteException;

	public void joinGame(String username, String gamename) throws RemoteException;

	public ArrayList<User> getUsers() throws RemoteException;

	public ArrayList<Game> getGames() throws RemoteException;

	public void userQuitGame(String username, String gamename) throws RemoteException;

	public void newUser(String username, String ip) throws RemoteException;

	public void newGame(String gamename, String dico) throws RemoteException;

	public void nextPlayer(String gamename,String word) throws RemoteException;

	public void startGame(String gamename) throws RemoteException;
}
