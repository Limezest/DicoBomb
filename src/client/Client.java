package client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Client {
	public static void main(String[] args) {
	SecurityManager security = System.getSecurityManager();
	System.setProperty("java.rmi.server.hostname", "192.168.1.2");

	if (security != null) {
		System.setSecurityManager(new java.lang.SecurityManager());
	}

	try {
		LocateRegistry.createRegistry(1099);
		ClientRMIServer gm = new ClientRMIServer();
		Naming.rebind("Dicobomb_client", gm);
		// GameManager.startGame("Partie1");

		System.out.println("Serveur pret.");
	} catch (Exception e) {
		System.out.println("Erreur serveur : " + e);
	}
}
}
