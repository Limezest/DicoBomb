package main;
import java.util.ArrayList;


public class UserManager implements ManagerInterface {
	private static ArrayList<User> users = new ArrayList<User>();

	public static ArrayList<User> getItems() {
		return users;
	}

	public static void addItem(String name){
		users.add(new User(name));
	}
	
	public static void delItem(String name){
		users.remove(new User(name));
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
