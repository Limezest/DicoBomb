package main;

import java.util.ArrayList;

public class GameManager implements ManagerInterface {
	//Attributs
	private static ArrayList<Game> games = new ArrayList<Game>();

	//Methodes : ManagerInterface
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
		for (Game item : games) {
			String itemName = item.getName();
			if (itemName.compareTo(gameName) == 0){
				System.out.println("Cette partie existe :"+itemName);
				return true;
			}
		}
		return false;
	}

	public static Game getItem(String gamename){
		for (Game item : games) {
			String itemName = item.getName();
			if (itemName.compareTo(gamename) == 0 ){
				return item;
			}
		}
		return null;
	}
	
	//Methodes : Autres
	public static void addUserToGame(String username, String gamename){
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)){
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);
			
			game.addUserToGame(username);
			user.setGame(game.getName());
		}
		else { System.out.println("Probleme");}
	}

	public static void delUserToGame(String username, String gamename){
		if (UserManager.itemExist(username) && GameManager.itemExist(gamename)){
			Game game = GameManager.getItem(gamename);
			User user = UserManager.getItem(username);
			
			game.delUserToGame(username);
			user.setGame(null);
		}
	}
}
