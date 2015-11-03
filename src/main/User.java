package main;

public class User implements java.io.Serializable {
	// Attributs
	private String name;
	private String game;
	private static final long serialVersionUID = 1L;
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