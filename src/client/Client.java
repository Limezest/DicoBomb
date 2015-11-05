package client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Client {
	public static void main(String[] args) {
	SecurityManager security = System.getSecurityManager();
	System.setProperty("java.rmi.server.hostname", "127.0.0.1");

	if (security != null) {
		System.setSecurityManager(new java.lang.SecurityManager());
	}

	try {
		LocateRegistry.createRegistry(1100);
		ClientRMIServer gm = new ClientRMIServer();
		Naming.rebind("Dicobomb", gm);
		// GameManager.startGame("Partie1");

		System.out.println("Serveur pret.");
	} catch (Exception e) {
		System.out.println("Erreur serveur : " + e);
	}
}
}
