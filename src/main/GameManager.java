package main;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

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

	public static void addItem(String gamename, String dicoName) {
		games.add(new Game(gamename, dicoName));
	}

	public static void delItem(String gamename) {
		games.remove(getItem(gamename));
	}

	public static boolean itemExist(String gamename) {
		String itemName;
		for (Game item : games) {
			itemName = item.getName();
			if (itemName.compareTo(gamename) == 0) {
				// System.out.println("Cette partie existe :"+itemName);
				return true;
			}
		}
		return false;
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
	public static void joinGame(String username, String gamename) {
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.addUserToGame(username);
			user.setGame(game.getName());
		} else {
			System.out.println("Probleme joinGame");
		}
	}

	public static void quitGame(String username, String gamename) {
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)) {
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);

			game.delUserToGame(username);
			user.setGame(null);
		} else {
			System.out.println("Probleme quitGame");
		}
	}

	public static void startGame(String gamename) {
		System.out.println("Lancement de la partie :" + gamename);

		// Selection aléatoire du premier joueur (index du tableau UserInGame)
		Game game = getItem(gamename);
		int random = (int) (Math.random() * (game.getUsersInGame().size()) + 1);
		game.setCurrentUser(random - 1);

		// Remplacer les system.out.println par une fonction qui envoie aux
		// client
		System.out.println("Au tour de :" + game.getUsersInGame().get(random - 1));
	}

	public static void nextPlayer(String gamename) {
		Game game = getItem(gamename);
		String pattern = game.getPattern();
		String word;
		Scanner keyboard = new Scanner(System.in);
		String currentUser = game.getUsersInGame().get(game.getCurrentUser());
		System.out.println("C'est au tour de :" + currentUser);
		System.out.println("Voici un patter :" + pattern);
		do {
			System.out.println("Entre un mot");
			word = (keyboard.nextLine());
			// ajouter la gestion du temps
		} while (!(game.testWord(word)));
		System.out.println("bien joué, ce mot existe");
		// changement du joueur
		if (game.getCurrentUser() >= game.getUsersInGame().size() - 1) {
			game.setCurrentUser(0);
		} else {
			game.setCurrentUser(game.getCurrentUser() + 1);
		}
	}
}
