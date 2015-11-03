package main;
import java.rmi.Remote;
import java.rmi.RemoteException; 
import java.util.ArrayList;
public interface MessageHandlerInterface extends Remote  {
	public  void messageHandler(String message) throws RemoteException;
	public void userExitGame(String username)throws RemoteException;
	public void joinGame(String username, String gamename)throws RemoteException;
	public ArrayList<User> getUsers()throws RemoteException;
	public ArrayList<Game> getGames()throws RemoteException;
	public void userQuitGame(String username, String gamename)throws RemoteException;
	public void newUser(String username)throws RemoteException;
	public void newGame(String gamename, String dico)throws RemoteException;
	public void nextPlayer(String username)throws RemoteException;
	public  void startGame(String gamename)throws RemoteException;
}
