package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {

		SecurityManager security = System.getSecurityManager();
		System.setProperty("java.rmi.server.hostname", "127.0.0.1");

		if (security != null) {
			System.setSecurityManager(new java.lang.SecurityManager());
		}

		try {
			LocateRegistry.createRegistry(1099);
			ServerRMI gm = new ServerRMI();
			Naming.rebind("Dicobomb", gm);
			// GameManager.startGame("Partie1");

			System.out.println("Serveur pret.");
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e);
		}
	}
}