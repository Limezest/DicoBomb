package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRMInterface extends Remote{
	 public void userJoinGame(String username) throws RemoteException;
	 public void userQuitGame(String username) throws RemoteException;
	 public void startGame(String message) throws RemoteException;
	 public void nextPlayer(String message) throws RemoteException;
	 public void wordNotExist(String message) throws RemoteException;
	 public void newLive(String live) throws RemoteException;
	 public void timeElapsed(String username) throws RemoteException;
	 public void hoteQuit(String username) throws RemoteException;
	 public void receiveMessage(String message) throws RemoteException;
}
