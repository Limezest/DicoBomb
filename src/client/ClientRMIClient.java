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

	public void userExitGame(String username) throws RemoteException {
		this.mhi.userExitGame(username);
	}

	public void joinGame(String username, String gamename) throws RemoteException {
		this.mhi.joinGame(username, gamename);
	}

	public ArrayList<User> getUsers() throws RemoteException {
		return this.mhi.getUsers();
	}

	public ArrayList<Game> getGames() throws RemoteException {
		return this.mhi.getGames();
	}

	public void userQuitGame(String username, String gamename) throws RemoteException {
		this.mhi.userQuitGame(username, gamename);
	}

	public void newUser(String username) throws RemoteException {
		this.mhi.newUser(username);
	}

	public void newGame(String gamename, String dico,String creator) throws RemoteException {
		this.mhi.newGame(gamename, dico,creator);
	}

	public void nextPlayer(String gamename, String word) throws RemoteException {
		this.mhi.nextPlayer(gamename, word);
	}

	public void startGame(String gamename) throws RemoteException {
		this.mhi.startGame(gamename);
	}

	public static void main(String[] argv) throws UnknownHostException {

	}
}