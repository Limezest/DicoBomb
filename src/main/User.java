package main;

import server.ServerRMIClient;

public class User implements java.io.Serializable {
	// Attributs
	private static final long serialVersionUID = 3485899236794999736L;
	private String username;
	private String gamename;
	private String ip;
	public ServerRMIClient cmh;
	
	// Contructeur
	public User(String username,String ip) {
		super();
		this.username = username;
		this.ip = ip;
	    //this.cmh = new ServerRMIClient(ip);
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