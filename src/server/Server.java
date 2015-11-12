package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

public class Server {
	public static ServerRMI srmi;
	public static Hashtable<String, ServerRMIClient> hashClient = new Hashtable<String, ServerRMIClient>();
	
	public Server() {
		this.newServer();
	}

	public ServerRMIClient newClient(String destIP) {
		ServerRMIClient crmi;
		crmi = new ServerRMIClient(destIP);
		return crmi;
	}

	public void newServer() {
		try {
			SecurityManager security = System.getSecurityManager();
			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			if (security != null) {
				System.setSecurityManager(new java.lang.SecurityManager());
			}
			LocateRegistry.createRegistry(1099);
			srmi = new ServerRMI();
			Naming.rebind("Dicobomb_server", srmi);
			// GameManager.startGame("Partie1");
			System.out.println("Serveur pret.");
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e);
		}
	}

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack" , "true");
		new Server();
	}
}