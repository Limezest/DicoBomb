package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Hashtable;

import client.ClientRMInterface;

public class ServerRMIClient {
	private ClientRMInterface cri;

	public ServerRMIClient() {
		connect();
	}

	public ServerRMIClient(String ip) {
		connect(ip);
	}

	private void connect() {
		String adress = "127.0.0.1";
		if (adress != null)
			connect(adress);
	}

	private void connect(String adress) {
		adress = "rmi://" + adress + "/Dicobomb_client";
		try {
			this.cri = (ClientRMInterface) Naming.lookup(adress);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		}
	}

	public static void invokeRMIClient(String ip, Actions action, String message) throws RemoteException {
		ServerRMIClient crmi = Server.hashClient.get(ip);
		switch (action.toString()) {
		case "userJoinGame":
			crmi.cri.userJoinGame(message);
			break;
		case "userQuitGame":
			crmi.cri.userQuitGame(message);
			break;
		case "startGame":
			crmi.cri.startGame(message);
			break;
		case "nextPlayer":
			crmi.cri.nextPlayer(message);
			break;
		case "wordNotExist":
			crmi.cri.wordNotExist(message);
			break;
		case "newLive":
			crmi.cri.newLive(message);
			break;
		case "timeElapsed":
			crmi.cri.timeElapsed(message);
			break;
		case "hoteQuit":
			crmi.cri.hoteQuit(message);
			break;
		case "sendMessage":
			crmi.cri.receiveMessage(message);
			break;
		}
	}

	public static void addClient(String ip) {
		Server.hashClient.put(ip, new ServerRMIClient(ip));
		System.out.println("Un client c'est connecté");
		System.out.println(Server.hashClient);
	}

	public static void delclient(String ip) {
		Server.hashClient.remove(ip);
	}

	public static Hashtable<String, ServerRMIClient> getClient() {
		return Server.hashClient;
	}

	public static void main(String[] argv) throws RemoteException {
	}
}
