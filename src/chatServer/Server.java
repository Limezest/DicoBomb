package chatServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
	public static ServerSocket ss = null;
	public static Thread t;
	private static ArrayList<Socket> clients = new ArrayList<Socket>();

	public static void addClient(Socket client) {
		clients.add(client);
	}

	public static void delClient(Socket client) {
		clients.remove(client);
	}

	public static ArrayList<Socket> getItems() {
		return clients;
	}

	public static void main(String[] args) {
		try {
			ss = new ServerSocket(2009);
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());
			t = new Thread(new AcceptConnexion(ss));
			t.start();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
