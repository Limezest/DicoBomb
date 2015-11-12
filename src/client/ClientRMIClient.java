package client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.Game;
import main.User;
import server.ServerRMInterface;

public class ClientRMIClient {
	private ServerRMInterface mhi;

	public ClientRMIClient() {
		connect();
	}

	public ClientRMIClient(String adress) {
		connect(adress);
	}

	private void connect() {
		String adress = "127.0.0.1";
		if (adress != null)
			connect(adress);
	}

	private void connect(String adress) {
		adress = "rmi://" + adress + "/Dicobomb_server";
		try {
			this.mhi = (ServerRMInterface) Naming.lookup(adress);
		} catch (Exception e) {
			System.out.print("Erreur RMI :");
			e.printStackTrace();
		}

	}

	public void userExit(String username) throws RemoteException {
		System.out.println("userExit"+this.mhi.userExit(username));
	}

	public void joinGame(String username, String gamename) throws RemoteException {
		if (this.mhi.joinGame(username, gamename)){
			Client.mygame=gamename;
			System.out.println("joinGame: true");
		}
		else {
			System.out.println("joinGame: false");
		}
	}

	public ArrayList<User> getUsers() throws RemoteException {
		return this.mhi.getUsers();
	}

	public ArrayList<Game> getGames() throws RemoteException {
		return this.mhi.getGames();
	}

	public void quitGame(String username, String gamename) throws RemoteException {
		if (this.mhi.quitGame(username, gamename)){
			Client.mygame=gamename;
			System.out.println("userQuitGame: true");
		}
		else {
			System.out.println("userQuitGame: false");
		}
	}

	public void newUser(String username) throws RemoteException {
		System.out.println("newUser:"+this.mhi.newUser(username));
	}

	public void newGame(String gamename, String dico,String creator) throws RemoteException {
		System.out.println("newGame:"+this.mhi.newGame(gamename, dico,creator));
	}

	public void nextPlayer(String gamename, String word) throws RemoteException {
		System.out.println("nextPlayer:"+this.mhi.nextPlayer(gamename, word));
	}

	public void startGame(String gamename) throws RemoteException {
		System.out.println("startGame:"+this.mhi.startGame(gamename));
	}
	
	public void sendMessage(String gamename,String sender,String message) throws RemoteException {
		this.mhi.sendMessage(gamename, sender, message);
	}

	public static void main(String[] argv) throws UnknownHostException {

	}
}