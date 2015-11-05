package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIServer extends UnicastRemoteObject implements ClientRMInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ClientRMIServer() throws RemoteException {
		super();
	}

	@Override
	public void test() throws RemoteException {
		System.out.println("Wallah que je suis beau");
		
	}

}
