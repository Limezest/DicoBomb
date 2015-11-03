package main;

public class User {
	// Attributs
	private String username;
	private String gamename;

	// Contructeur
	public User(String username) {
		super();
		this.username = username;
	}

	// Methodes : getters et setters
	public String getName() {
		return username;
	}

	public String getGame() {
		return gamename;
	}

	public void setGame(String gamename){
		this.gamename=gamename;
	}

	
	// Methodes : ToString()
	@Override
	public String toString() {
		return "User [name=" + username + ", game=" + gamename + "]";
	}
}
