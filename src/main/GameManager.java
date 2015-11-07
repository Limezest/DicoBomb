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
		String ip;
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.addUserToGame(username);
			user.setGame(game.getName());
			
			// RMI
			for (String userInGame : game.getUsersInGame()){
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("joinGame : envoie a :"+UserManager.getItem(userInGame).getIP());
				ServerRMIClient.invokeRMIClient(ip,Actions.userJoinGame, username);
			}
		} else {
			System.out.println("Probleme joinGame de : "+username+" sur "+gamename);
		}
	}

	public static void quitGame(String username, String gamename) throws RemoteException {
		String ip;
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.delUserToGame(username);
			user.setGame(null);
			
			// RMI
			for (String userInGame : game.getUsersInGame()){
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("quitGame : envoie a :"+UserManager.getItem(userInGame).getIP());
				ServerRMIClient.invokeRMIClient(ip,Actions.userQuitGame, username);
			}
		} else {
			System.out.println("Probleme quitGame de : "+username+" sur "+gamename);
		}
	}

	public static void startGame(String gamename) throws RemoteException {
		System.out.println("Lancement de la partie :" + gamename);

		// Selection aleatoire du premier joueur (index du tableau UserInGame)
		Game game = getItem(gamename);
		int random = (int) (Math.random() * (game.getUsersInGame().size()) + 1);
		game.setCurrentUser(random - 1);

		// RMI
		System.out.println(game.getUsersInGame().toString());
		for (String userInGame : game.getUsersInGame()){
			System.out.println("startGame : envoie a :"+UserManager.getItem(userInGame).getIP());
			ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(),Actions.startGame,(game.getUsersInGame().get((game.getCurrentUser()))+","+game.newPattern()));
		}
	}	
	
	public static void nextPlayer(String gamename,String word) throws RemoteException {
		Game game = getItem(gamename);
		String ip;

		
		String currentUsername = game.getUsersInGame().get(game.getCurrentUser());

		if (game.testWord(word)){
			//si mot existe et non deja utilise => changement de joueur
			if (game.getCurrentUser() >= game.getUsersInGame().size() - 1) {
				game.setCurrentUser(0);
			} else {
				game.setCurrentUser(game.getCurrentUser() + 1);
			}
			UserManager.getItem(currentUsername).addChar(word);
			// RMI
			for (String userInGame : game.getUsersInGame()){
				ip = UserManager.getItem(userInGame).getIP();
				currentUsername = game.getUsersInGame().get(game.getCurrentUser());
				System.out.println("nextPlayer : envoie a :"+ip);
				ServerRMIClient.invokeRMIClient(ip,Actions.nextPlayer,(currentUsername+","+game.newPattern()));
			}
		}
		else {
			String message;
			ip = UserManager.getItem(game.getUsersInGame().get(game.getCurrentUser())).getIP();
			if (game.isUsedWord(word)){
				message = "Mot deja utilise";
			}
			else {message = "Mot non présent dans le dictionnaire";}
			// RMI
			System.out.println("wordNotExist : envoie a :"+ip);
			ServerRMIClient.invokeRMIClient(ip,Actions.wordNotExist,message);
		}
		System.out.println(game.getUsedWords());
		System.out.println(UserManager.getItem(currentUsername).getUsedChars());
	}
}
