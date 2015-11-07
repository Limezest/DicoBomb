package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	private static ServerRMI srmi;
	
	public Server(String listenIP){
		this.newServer(listenIP);
	}
	
	public ServerRMIClient newClient(String destIP){
		ServerRMIClient crmi;
		crmi = new ServerRMIClient(destIP); 
		return crmi;
	}
	public void newServer(String listenIP){
		try {
			SecurityManager security = System.getSecurityManager();
			//System.setProperty("java.rmi.server.hostname", listenIP);
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
		new Server("192.168.1.1");
	}
}