package main;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import chatServer.Server;
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

	public static boolean addItem(String gamename, String dicoName) {
		if (!(games.contains(getItem(gamename)))){
			games.add(new Game(gamename, dicoName));
		}
		return games.contains(getItem(gamename));
	}

	public static boolean delItem(String gamename) {
		games.remove(getItem(gamename));
		return (!games.contains(getItem(gamename)));
	}

	public static boolean itemExist(String gamename) {
//		String itemName;
//		for (Game item : games) {
//			itemName = item.getName();
//			if (itemName.compareTo(gamename) == 0) {
//				// System.out.println("Cette partie existe :"+itemName);
//				return true;
//			}
//		}
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
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.addUserToGame(username);
			user.setGame(game.getName());
			for (String userInGame : game.getUsersInGame()){
				ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(),Actions.userJoinGame, username);
			}
		} else {
			System.out.println("Probleme joinGame");
		}
	}

	public static void quitGame(String username, String gamename) throws RemoteException {
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.delUserToGame(username);
			user.setGame(null);
			for (String userInGame : game.getUsersInGame()){
				ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(),Actions.userQuitGame, username);
			}
			//appel des procedures RMI
		} else {
			System.out.println("Probleme quitGame");
		}
	}

	public static String startGame(String gamename) throws RemoteException {
		System.out.println("Lancement de la partie :" + gamename);

		// Selection aléatoire du premier joueur (index du tableau UserInGame)
		Game game = getItem(gamename);
		int random = (int) (Math.random() * (game.getUsersInGame().size()) + 1);
		game.setCurrentUser(random - 1);

		// Remplacer les system.out.println par une fonction qui envoie aux
		for (String userInGame : game.getUsersInGame()){
			ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(),Actions.startGame, game.getUsersInGame().get(game.getCurrentUser()));
		}
		return game.getUsersInGame().get(game.getCurrentUser());
	}	
	
	public static void nextPlayer(String gamename,String word) throws RemoteException {
		Game game = getItem(gamename);
		
		if (game.testWord(word)){
			//si mot existe - changement de joueur
			if (game.getCurrentUser() >= game.getUsersInGame().size() - 1) {
				game.setCurrentUser(0);
			} else {
				game.setCurrentUser(game.getCurrentUser() + 1);
			}
			for (String userInGame : game.getUsersInGame()){
				ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(),Actions.nextPlayer,game.newPattern()+","+game.getUsersInGame().get((game.getCurrentUser())));
			}
		}
		else {
			ServerRMIClient.invokeRMIClient(UserManager.getItem(game.getUsersInGame().get(game.getCurrentUser())).getIP(),Actions.wordNotExist,"");
		}
	}
}
