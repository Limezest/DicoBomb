package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

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
//			client.crmic.newUser("benoit");
//			client.crmic.newUser("pierre");
//			client.crmic.newUser("cyril");
//			client.crmic.newUser("lens");
//			client.crmic.newGame("Partie1", "Dico1");
//			client.crmic.newGame("Partie2", "Dico1");
//			client.crmic.joinGame("benoit", "Partie1");
//			client.crmic.joinGame("pierre", "Partie1");
//			client.crmic.joinGame("cyril", "Partie1");
//			client.crmic.joinGame("lens", "Partie1");
//			client.crmic.userQuitGame("pierre", "Partie1");
	//		client.crmic.startGame("Partie1");
		System.out.println(client.crmic.getUsers());
		System.out.println(client.crmic.getGames());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
