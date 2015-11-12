package main;

import java.rmi.RemoteException;
import java.util.Hashtable;

import server.Actions;
import server.ServerRMIClient;

public class User implements java.io.Serializable {
	// Attributs
	private static final long serialVersionUID = 3485899236794999736L;
	private String username;
	private String gamename;
	private String ip;
	private Hashtable<Character, Integer> usedChars;
	private Integer live;

	// Contructeur
	public User(String username, String ip) {
		super();
		this.username = username;
		this.gamename = "";
		this.ip = ip;
		this.live = 0;
		this.usedChars = new Hashtable<Character, Integer>();
	}

	// Methodes : getters et setters
	public String getName() {
		return username;
	}

	public String getGame() {
		return gamename;
	}

	public boolean setGame(String gamename) {
		this.gamename = gamename;
		return this.gamename.equals(gamename);
	}

	public boolean setName(String newname) {
		this.username = newname;
		return this.username.equals(newname);
	}

	public String getIP() {
		return this.ip;
	}

	public Hashtable<Character, Integer> getUsedChars() {
		return usedChars;
	}

	public void addChar(String word) throws RemoteException {
		for (Character item : word.toCharArray()) {
			if (usedChars.containsKey(item)) {
				usedChars.put(item, (usedChars.get(item) + 1));
			} else {
				usedChars.put(item, 1);
			}
		}

		// Test si 22 lettres differentes
		if (usedChars.size() >= 22) {
			if (live <= 3) {
				addLive();
				// System.out.println("Nouvelle vie :"+live);
				usedChars.clear();

				// RMI
				//ServerRMIClient.invokeRMIClient(ip, Actions.newLive, String.valueOf(live));
			}
		}
	}

	public void addLive(){
		live++;
	}
	
	public void delLive(){
		live--;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", gamename=" + gamename + ", ip=" + ip + ", usedChars=" + usedChars
				+ ", live=" + live + "]";
	}
}