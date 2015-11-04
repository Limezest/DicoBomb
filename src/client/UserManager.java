package client;

import java.util.ArrayList;

public class UserManager {
	// Attributs
	private static ArrayList<User> users = new ArrayList<User>();

	// Methodes : ManagerInterface
	public static ArrayList<User> getItems() {
		return users;
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
