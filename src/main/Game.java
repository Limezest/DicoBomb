package main;

import java.util.ArrayList;

public class Game {
	private Dico Dictonnary;
	private ArrayList<User> users;
	public Game(Dico dictonnary, ArrayList<User> users) {
		super();
		Dictonnary = dictonnary;
		this.users = users;
	}
	@Override
	public String toString() {
		return "Game [Dictonnary=" + Dictonnary + ", users=" + users + "]";
	}
}
