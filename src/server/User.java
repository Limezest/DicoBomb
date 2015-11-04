package server;

public class User implements java.io.Serializable {
	// Attributs
	private String username;
	private String gamename;
	private static final long serialVersionUID = 1L;

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

	public void setGame(String gamename) {
		this.gamename = gamename;
	}

	// Methodes : ToString()
	@Override
	public String toString() {
		return "User [name=" + username + ", game=" + gamename + "]";
	}
}