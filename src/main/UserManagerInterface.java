package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserManagerInterface extends Remote{
	public  User getItem(String username) throws RemoteException;
	public  void nextPlayer(String gameName)throws RemoteException;
}
