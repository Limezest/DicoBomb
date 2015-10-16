package main;

import java.util.ArrayList;

public class Game {
	// Attributs
	private ArrayList<String> usersInGame = new ArrayList<String>();
	private Dictionnary dico;
	private String name;
	private String currentUser;
	
	// Contructeur
	public Game(String gamename) {
		super();
		this.name = gamename;
		this.dico = new Dictionnary("Dico 1", "C:/");
	}
	
	// Methodes : getters et setters
	public String getName(){
		return this.name;
	}
	public ArrayList<String> getUsersInGame(){
		return usersInGame;
	}
	// Methodes : users

	public void addUserToGame(String username){
		usersInGame.add(username);
	}
	public void delUserToGame(String username) {
		usersInGame.remove(username);
	}
	
	// Methodes : Dico
	/*public void addWord(String word){
		dico.add(word);
	}
	public void testWord(String word) {
		dico.testWord(username);
	}
	public void getPattern(String username) {
		dico.getPattern(username);
	}*/
	
	// Methodes : ToString()
	@Override
	public String toString() {
		return "Game [users=" + usersInGame + ", name=" + name + "]";
	}
}
