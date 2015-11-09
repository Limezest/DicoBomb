package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
	public static ClientRMIServer crmis;
	public static ClientRMIClient crmic;
	public static String myusername = null;

	public Client(String ip,Integer port) {
		newServer(port);
		newClient(ip);
	}

	public void newServer(Integer port) {
		try {
			SecurityManager security = System.getSecurityManager();
//			 System.setProperty("java.rmi.server.hostname", "192.168.43.238");
			if (security != null) {
				System.setSecurityManager(new java.lang.SecurityManager());
			}
			LocateRegistry.createRegistry(port);
			crmis = new ClientRMIServer();
			Naming.rebind("Dicobomb_client", crmis);
			System.out.println("Serveur pret.");
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e);
		}
	}

	public void newClient(String ip) {
		crmic = new ClientRMIClient(ip);
	}

	public static String getMyUsername(){
		return Client.myusername;
	}
	
	public static void client1() {
		try {
			Client.crmic.newUser("benoit");
			Client.crmic.newGame("Partie1", "Dico", "benoit");
			Client.crmic.joinGame("benoit", "Partie1");
			Client.myusername = "benoit";
			Client.crmic.startGame("Partie1");

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void client2() {
		try {
			Client.crmic.newUser("lens");
			Client.crmic.joinGame("lens", "Partie1");
			Client.myusername = "lens";
//			Client.crmic.startGame("Partie1");

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException {
//		Scanner s = new Scanner(System.in);
//		String ip;
//		String name;
//		Integer port;
//		System.out.println("Bienvenue sur DicoBomb\n\tEntrer l'adresse du serveur :");
//		ip=s.nextLine();
//		System.out.println("\tEntrer le port du serveur local :");
//		port = Integer.parseInt(s.nextLine());
//		new Client(ip,port);
//		System.out.println("\tEntrer votre nom d'utilisateur :");
//		name = s.nextLine();
//		new Client(ip,port);
//		if (crmic.newUser(name)){
//			myusername = name;
//		}
//		else {
//			while (crmic.newUser(name)){
//				System.out.println("Mauvais nom d'utilisateur");
//				name = s.nextLine();
//			}
//		}
		Client client = new Client("192.168.1.1",1099);
//		client1();
		 client2();

	}
}
