package main;

public class User implements java.io.Serializable {
	// Attributs
	private String username;
	private String gamename;
	private String ip;
	private static final long serialVersionUID = 1L;

	// Contructeur
	public User(String username,String ip) {
		super();
		this.username = username;
		this.ip = ip;
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
	
	public void setName(String newname) {
		this.username = newname;
	}
	
	public String getIP(){
		return this.ip;
	}
	// Methodes : ToString()
	@Override
	public String toString() {
		return "User [username=" + username + ", gamename=" + gamename + ", ip=" + ip + "]";
	}
}