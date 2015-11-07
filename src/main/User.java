package main;

import java.util.Hashtable;

import server.ServerRMIClient;

public class User implements java.io.Serializable {
	// Attributs
	private static final long serialVersionUID = 3485899236794999736L;
	private String username;
	private String gamename;
	private String ip;
	private Hashtable<Character, Integer> usedChars;
	// Contructeur
	public User(String username,String ip) {
		super();
		this.username = username;
		this.ip = ip;
		this.usedChars = new Hashtable<Character, Integer>();
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
	
	public Hashtable<Character, Integer> getUsedChars(){
		return usedChars;
	}
	
	public void addChar(String word){
		for (Character item : word.toCharArray()){
			if (usedChars.containsKey(item)){
				usedChars.put(item, (usedChars.get(item)+1));
			}
			else { usedChars.put(item, 1);}
		}
	}
	// Methodes : ToString()
	@Override
	public String toString() {
		return "User [username=" + username + ", gamename=" + gamename + ", ip=" + ip + "]";
	}
	public static void main(String[] args) {
		User test = new User("benoit","ip");
		test.addChar("TEST");
		System.out.println(test.getUsedChars());
	}
}