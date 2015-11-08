package main;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.Actions;
import server.ServerRMIClient;

public class GameManager {
	// Attributs
	private static ArrayList<Game> games = new ArrayList<Game>();

	protected GameManager() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Methodes : Manager
	public static ArrayList<Game> getItems() {
		return games;
	}

	public static boolean addItem(String gamename, String dicoName, String creator) {
		if (!(games.contains(getItem(gamename)))) {
			games.add(new Game(gamename, dicoName, "creator"));
		} else {
			return false;
		}
		return games.contains(getItem(gamename));
	}

	public static boolean delItem(String gamename) {
		games.remove(getItem(gamename));
		return (!games.contains(getItem(gamename)));
	}

	public static boolean itemExist(String gamename) {
		return games.contains(getItem(gamename));
	}

	public static Game getItem(String gamename) {
		String itemName;
		for (Game item : games) {
			itemName = item.getName();
			if (itemName.compareTo(gamename) == 0) {
				return item;
			}
		}
		return null;
	}

	// Methodes : Parties
	public static void joinGame(String username, String gamename) throws RemoteException {
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			GameManager.getItem(gamename).addUserToGame(username);
		} else {
			System.out.println("Probleme joinGame de : " + username + " sur " + gamename);
		}
	}

	public static void quitGame(String username, String gamename) throws RemoteException {
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			GameManager.getItem(gamename).delUserToGame(username);
		} else {
			System.out.println("Probleme quitGame de : " + username + " sur " + gamename);
		}
	}

	public static void startGame(String gamename) throws RemoteException {
		if (GameManager.itemExist(gamename)) {
			GameManager.getItem(gamename).gameIsStart();
		}
	}

	public static void nextPlayer(String gamename, String word) throws RemoteException {
		GameManager.getItem(gamename).nextPlayer(word);
	}

	public static void banPlayer(String username, String gamename) throws RemoteException {
		quitGame(username, gamename);
	}
}
