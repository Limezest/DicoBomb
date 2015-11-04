package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRMInterface extends Remote{
	 public void test() throws RemoteException;
}
