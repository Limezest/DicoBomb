package main;

import java.util.ArrayList;

public class GameManager implements ManagerInterface {
	private static ArrayList<Game> games = new ArrayList<Game>();

	public static ArrayList<Game> getItems() {
		return games;
	}

	public static void addItem(Dico dico, ArrayList<User> users){
		games.add(new Game(dico,users));
	}
	
	public static void delItem(Dico dico, ArrayList<User> users){
		games.remove(new Game(dico,users));
	}
	
	public static void main (String[] args){
		UserManager.addItem("Benoit");
		UserManager.addItem("Cyril");
		UserManager.addItem("Pierre");
		UserManager.addItem("Lens");
		System.out.println(UserManager.getItems());
	    System.out.println("Hello World");
	}
}
