package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.Game;
import main.User;

public interface ServerRMInterface extends Remote {
	public String newRandomUser()throws RemoteException;
	
	public boolean userExit(String username) throws RemoteException;

	public boolean joinGame(String username, String gamename) throws RemoteException;

	public ArrayList<User> getUsers() throws RemoteException;

	public ArrayList<Game> getGames() throws RemoteException;

	public boolean quitGame(String username, String gamename) throws RemoteException;

	public boolean newUser(String username) throws RemoteException;

	public boolean newGame(String gamename, String dico,String creator) throws RemoteException;

	public boolean nextPlayer(String gamename,String word) throws RemoteException;

	public boolean startGame(String gamename) throws RemoteException;
	
	public void sendMessage(String gamename,String sender,String message) throws RemoteException;
	
}
