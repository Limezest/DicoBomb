package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRMInterface extends Remote{
	 public void newPattern(String word) throws RemoteException;
	 public void changeCurrentUser(String username) throws RemoteException;
	 public void userJoinGame(String username) throws RemoteException;
	 public void userQuitGame(String username) throws RemoteException;
	 public void startGame(String username) throws RemoteException;
	 public void nextPlayer(String message) throws RemoteException;
	 public void wordNotExist() throws RemoteException;
}
