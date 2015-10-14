package main;

public class main {

	public static void main(String[] args) {
		UserManager.addItem("Benoit");
		UserManager.addItem("Cyril");
		UserManager.addItem("Pierre");
		UserManager.addItem("Lens");
		//System.out.println(UserManager.getItems());
		GameManager.addItem("Partie 1");
		GameManager.addItem("Partie 2");
		GameManager.addItem("Partie 3");
		//System.out.println(GameManager.getItems());
		GameManager.addUserToGame("Benoit","Partie 1");
		GameManager.addUserToGame("Pierre", "Partie 1");
		GameManager.addUserToGame("Lens", "Partie 1");
		//System.out.println(GameManager.getItems());
		System.out.println(UserManager.getItem("Benoit"));
		GameManager.delUserToGame("Benoit","Partie 1");
		//System.out.println(GameManager.getItems());
		System.out.println(UserManager.getItem("Benoit"));
		
	}

}
