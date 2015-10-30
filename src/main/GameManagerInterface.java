package main;
import java.rmi.Remote;
import java.rmi.RemoteException; 
public interface GameManagerInterface extends Remote {
	public  void joinGame(String username, String gamename) throws RemoteException;
	public  void nextPlayer(String gameName)throws RemoteException;
}
