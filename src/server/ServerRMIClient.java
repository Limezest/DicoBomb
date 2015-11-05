package server;

import java.rmi.Naming;
import java.rmi.RemoteException;

import client.ClientRMIClient;
import client.ClientRMInterface;

public class ServerRMIClient {
	private ClientRMInterface cri ;
    public ServerRMIClient() {
    	connect();
	}
	private void connect() {
    	String adress="127.0.0.1";
    	if (adress!=null) connect(adress);
    }

    private void connect(String adress) {
    	adress="rmi://"+adress+"/Dicobomb";
    	try {
		    this.cri = (ClientRMInterface) Naming.lookup(adress);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		} 
    }
	public void test ()throws RemoteException
	{
		this.cri.test();
	}
	public static void main (String [] argv) {
		ServerRMIClient cmh = new ServerRMIClient(); 
			cmh.connect();
    	try {

    		cmh.test();
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
}
