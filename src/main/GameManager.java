package main;

import java.util.ArrayList;
import java.math.*;

public class GameManager implements ManagerInterface {
	// Attributs
	private static ArrayList<Game> games = new ArrayList<Game>();

	// Methodes : ManagerInterface
	public static ArrayList<Game> getItems() {
		return games;
	}

	public static void addItem(String gameName){
		games.add(new Game(gameName));
	}
	
	public static void delItem(String gameName){
		games.remove(getItem(gameName));
	}
	
	public static boolean itemExist(String gameName){
		String itemName;
		for (Game item : games) {
			itemName = item.getName();
			if (itemName.compareTo(gameName) == 0){
				//System.out.println("Cette partie existe :"+itemName);
				return true;
			}
		}
		return false;
	}

	public static Game getItem(String gamename){
		String itemName;
		for (Game item : games) {
			itemName = item.getName();
			if (itemName.compareTo(gamename) == 0 ){
				return item;
			}
		}
		return null;
	}
	
	// Methodes : Autres
	public static void joinGame(String username, String gamename){
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)){
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);
			
			game.addUserToGame(username);
			user.setGame(game.getName());
		}
		else { System.out.println("Probleme joinGame");}
	}

	public static void quitGame(String username, String gamename){
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)){
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);
			
			game.delUserToGame(username);
			user.setGame(null);
		}
		else { System.out.println("Probleme quitGame");}
	}

	public static void startGame(String gamename){
		System.out.println("Lancement de la partie :"+gamename);
		
		// Selection aléatoire de l'utilisateur
		Game game = getItem(gamename);
		int random = (int) (Math.random()*(game.getUsersInGame().size())+1);
		System.out.println(game.getUsersInGame().get(random-1));
	}
}
