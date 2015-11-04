package client;

import java.util.ArrayList;

public class UserManager {
	// Attributs
	private static ArrayList<User> users = new ArrayList<User>();

	// Methodes : ManagerInterface
	public static ArrayList<User> getItems() {
		return users;
	}

	public static void addItem(String username) {
		users.add(new User(username));
		// System.out.println("Ajout de :"+username);
		// System.out.println("Ajout de :"+name);
	}

	public static void delItem(String username) {
		users.remove(getItem(username));
	}

	public static boolean itemExist(String username) {
		String itemName;
		for (User item : users) {
			itemName = item.getName();
			if (itemName.compareTo(username) == 0) {
				return true;
			}
		}
		return false;
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
}
