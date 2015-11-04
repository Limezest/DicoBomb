package client;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GameManager {
	// Attributs
	private static ArrayList<Game> games = new ArrayList<Game>();

	protected GameManager() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Methodes : ManagerInterface
	public static ArrayList<Game> getItems() {
		return games;
	}
	
	public static void addGames(ArrayList<Game> games){
		games.clear();
		games.addAll(games);
	}
	
}
