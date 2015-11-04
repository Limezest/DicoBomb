package client;

import java.util.ArrayList;

public class Game {
	// Attributs
	private ArrayList<String> usersInGame = new ArrayList<String>();
	private Dictionnary dico;
	private String name;
	private int currentUser;

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
	public int getCurrentUser() {
		return this.currentUser;
	}
	public Dictionnary getDico(){
		return this.dico;
	}
	// Methodes : users

	// Methodes : Dico

	// Methodes : ToString()
	@Override
	public String toString() {
		return "Game [users=" + usersInGame + ", name=" + name + "]";
	}
}
