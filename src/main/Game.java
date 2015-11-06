package main;

import java.util.ArrayList;

public class Game implements java.io.Serializable {
	// Attributs
	private ArrayList<String> usersInGame = new ArrayList<String>();
	private Dictionnary dico;
	private String name;
	private int currentUser;
	private static final long serialVersionUID = 7605941372064698361L;

	// Contructeur
	public Game(String gamename, String dicoName) {
		super();
		this.name = gamename;
		this.dico = new Dictionnary("dico1", "/Users/benoitmenard/Documents/genie_logiciel/git/src/main");
	}

	// Methodes : getters et setters
	public String getName() {
		return this.name;
	}

	public ArrayList<String> getUsersInGame() {
		return usersInGame;
	}

	public void setCurrentUser(int userName) {
		this.currentUser = userName;
	}

	public int getCurrentUser() {
		return this.currentUser;
	}
	// Methodes : users

	public void addUserToGame(String username) {
		usersInGame.add(username);
	}

	public void delUserToGame(String username) {
		usersInGame.remove(username);
	}

	// Methodes : Dico
	public boolean testWord(String word) {
		return dico.wordExiste(word);
	}

	public String getPattern() {
		return dico.genPattern();
	}

	public boolean newPattern() {
		dico.genPattern();
		return true;
	}

	// Methodes : ToString()
	@Override
	public String toString() {
		return "Game [users=" + usersInGame + ", name=" + name + "]";
	}
}
