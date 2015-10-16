package main;

public class User {
	// Attributs
	private String name;
	private String game;

	// Contructeur
	public User(String name) {
		super();
		this.name = name;
	}

	// Methodes : getters et setters
	public String getName() {
		return name;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game){
		this.game=game;
	}

	
	// Methodes : ToString()
	@Override
	public String toString() {
		return "User [name=" + name + ", game=" + game + "]";
	}
}
