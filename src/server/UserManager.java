package server;

import java.util.ArrayList;

public class UserManager {
	// Attributs
	private static ArrayList<User> users = new ArrayList<User>();

	// Methodes : Manager
	public static ArrayList<User> getItems() {
		return users;
	}

	public static boolean addItem(String username) {
		if(!(users.contains(getItem(username)))){
			users.add(new User(username));
		}
		return users.contains(getItem(username));
	}

	public static boolean delItem(String username) {
		users.remove(getItem(username));
		return (!users.contains(getItem(username)));
	}

	public static boolean itemExist(String username) {
//		String itemName;
//		for (User item : users) {
//			itemName = item.getName();
//			if (itemName.compareTo(username) == 0) {
//				return true;
//			}
//		}
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
		if (users.contains(getItem(newname))){
			return false;
		}
		else {
			getItem(username).setName(newname);
			return true;
		}
	}

	public static String randomName(){
		//TO DO : 
		return "OK";
	}
}
