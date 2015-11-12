package main;

import java.util.ArrayList;

public class UserManager {
	// Attributs
	private static ArrayList<User> users = new ArrayList<User>();

	// Methodes : Manager
	public static ArrayList<User> getItems() {
		return users;
	}

	public static boolean addItem(String username,String ip) {
		if(!(users.contains(getItem(username)))){
			users.add(new User(username,ip));
			System.out.println("Ajout de l'utilisateur :"+username);
		}
		else {
			System.out.println("Utilisateur existe deja :"+username);
		}
		return itemExist(username);
	}

	public static boolean delItem(String username) {
		if(users.contains(getItem(username))){
			users.remove(getItem(username));
			System.out.println("Suppression de l'utilisateur :"+username);
		}
		else {
			System.out.println("Utilisateur n'existe pas :"+username);
		}
		return (!itemExist(username));
	}

	public static boolean itemExist(String username) {
		return users.contains(getItem(username));
	}

	public static User getItem(String username) {
		String itemName;
		for (User item : users) {
			itemName = item.getName();
			if (itemName.compareTo(username) == 0) {
				return item;
			}
		}
		return null;
	}
	// Methodes : Autres
	public static boolean changeName(String username, String newname){
		if (itemExist(username)){
			System.out.println("Impossible de changer le nom - Utilisateur existe deja");
			return false;
		}
		else {
			System.out.println("Changement de nom de "+username+ "en "+newname);
			return getItem(username).setName(newname);
		}
	}

	public static String randomName(){
		int i=0;
		while (i<1000){
			System.out.println("guest"+i);
			if (!(itemExist("guest"+i))){
				return "guest"+i;
			}
			i++;
		}
		return null;
	}

}
