package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Hashtable;

import client.ClientRMIClient;
import client.ClientRMInterface;

public class ServerRMIClient {
	private ClientRMInterface cri ;
	private static Hashtable<String, ServerRMIClient> hashClient= new Hashtable<String, ServerRMIClient>();

    public ServerRMIClient() {
    	connect();
	}
    public ServerRMIClient(String ip) {
    	connect(ip);
	}
	
    private void connect() {
    	String adress="127.0.0.1";
    	if (adress!=null) connect(adress);
    }
    private void connect(String adress) {
    	adress="rmi://"+adress+"/Dicobomb_client";
    	try {
		    this.cri = (ClientRMInterface) Naming.lookup(adress);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		} 
    }
	
    public static void invokeRMIClient(String ip, Actions action, String message) throws RemoteException{
    	ServerRMIClient crmi = hashClient.get(ip);
    	switch (action.toString()){
    		case "changePattern" : 
    			crmi.cri.newPattern(message);
    			break;
    		case "changeCurrentUser" :
    			crmi.cri.changeCurrentUser(message);
    			break;
    		case "userJoinGame":
    			crmi.cri.userJoinGame(message);
    			break;
    		case "userQuitGame":
    			crmi.cri.userQuitGame(message);
    			break;
    	}
    }
    
    public static void addClient(String ip){
    	hashClient.put(ip, new ServerRMIClient(ip));
    	System.out.println(hashClient);
    }
    public static void delclient(String ip){
    	hashClient.remove(ip);
    }
    
    public static void main (String [] argv) {
		//ServerRMIClient cmh = new ServerRMIClient("127.0.0.1"); 
    }
}
