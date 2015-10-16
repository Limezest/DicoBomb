package main;

import java.util.ArrayList;

public class Game {
	//Attributs
	private ArrayList<String> users = new ArrayList<String>();
	private String name;
	
	//Contructeur
	public Game(String gameName) {
		super();
		this.name = gameName;
	}
	
	//Methodes : getters et setters
	public String getName(){
		return this.name;
	}
	public ArrayList<String> getUsers(){
		return users;
	}
	//Methodes : autres

	public void addUserToGame(String username){
		users.add(username);
	}
	public void delUserToGame(String username) {
		users.remove(username);
	}
	
	//Methodes : ToString()
	@Override
	public String toString() {
		return "Game [users=" + users + ", name=" + name + "]";
	}


}
