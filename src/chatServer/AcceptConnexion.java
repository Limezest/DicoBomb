package chatServer;

import java.io.*;
import java.net.*;

public class AcceptConnexion implements Runnable {
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	public Thread t2;

	public AcceptConnexion(ServerSocket ss) {
		this.serverSocket = ss;
	}

	public void run() {
		try {
			while (true) {
				clientSocket = serverSocket.accept();
				System.out.println("Un client c'est connecté : " + clientSocket.getRemoteSocketAddress());
				// Ajout du client à liste des clients
				Server.addClient(clientSocket);
				t2 = new Thread(new ChatClientServeur(clientSocket));
				t2.start();
			}
		} catch (IOException e) {
			System.err.println("Erreur serveur");
		}
	}
}
