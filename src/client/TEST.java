package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import main.GameManager;
import server.ServerRMIClient;

public class TEST {
	private static ClientRMIServer crmis;
	private static ClientRMIClient crmic;
	private static String myusername;

	public TEST() {
		//newServer();
		newClient("127.0.0.1");
	}

	public void newServer() {
		try {
			SecurityManager security = System.getSecurityManager();
			// System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			if (security != null) {
				System.setSecurityManager(new java.lang.SecurityManager());
			}
			LocateRegistry.createRegistry(1088);
			crmis = new ClientRMIServer();
			Naming.rebind("Dicobomb_client", crmis);
			System.out.println("Serveur pret.");
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e);
		}
	}

	public void newClient(String ip){
		crmic = new ClientRMIClient(ip);
	}

	public static void main(String[] args) {
		TEST client = new TEST();
		try {
			client.crmic.startGame("Partie1");
			//System.out.println(client.crmic.getUsers());
			//System.out.println(client.crmic.getGames());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//System.out.println(GameManager.getItems());
		//System.out.println(GameManager.getItem("Partie1"));
		//System.out.println(ServerRMIClient.getClient().toString());
	}
}
