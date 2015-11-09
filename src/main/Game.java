package main;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.Actions;
import server.ServerRMIClient;

public class Game implements java.io.Serializable {
	// Attributs
	private ArrayList<String> usersInGame = new ArrayList<String>();
	// Joueur en train de jouer
	private ArrayList<String> usersPlay = new ArrayList<String>();
	// Joueur toujours dans la partie, mais ayant perdu
	private ArrayList<String> usersLoose = new ArrayList<String>();
	private String currentUser;
	private Integer indexCurrentUser;
	private String creator;
	private Dictionnary dico;
	private String name;
	private TimerEg timer;
	private static final long serialVersionUID = 7605941372064698361L;

	// Contructeur
	public Game(String gamename, String dicoName, String creator) {
		super();
		this.name = gamename;
		this.creator = creator;
		this.dico = new Dictionnary("dico1", "/Users/benoitmenard/Documents/genie_logiciel/git/dictionnaire");
	}

	// Methodes : getters et setters
	public String getName() {
		return this.name;
	}

	public ArrayList<String> getUsersInGame() {
		return usersInGame;
	}

	public ArrayList<String> getUsersPlay() {
		return usersPlay;
	}

	public ArrayList<String> getUsersLoose() {
		return usersLoose;
	}

	public void setCurrentUser(String username) {
		this.currentUser = username;
	}

	public String getCurrentUser() {
		return this.currentUser;
	}
	// Methodes : users

	public void addUserToGame(String username) throws RemoteException {
		String ip;
		UserManager.getItem(username).setGame(getName());
		usersInGame.add(username);

		// RMI
		for (String userInGame : getUsersInGame()) {
			ip = UserManager.getItem(userInGame).getIP();
			System.out.println("addUserToGame : envoie a :" + UserManager.getItem(userInGame).getIP());
			ServerRMIClient.invokeRMIClient(ip, Actions.userJoinGame, username);
		}
	}

	public void delUserToGame(String username) throws RemoteException {
		String ip;
		UserManager.getItem(username).setGame(null);
		;
		usersInGame.remove(username);

		// RMI
		for (String userInGame : getUsersInGame()) {
			ip = UserManager.getItem(userInGame).getIP();
			System.out.println("delUserToGame : envoie a :" + UserManager.getItem(userInGame).getIP());
			ServerRMIClient.invokeRMIClient(ip, Actions.userQuitGame, username);
		}

	}

	// Methodes : partie
	public void gameIsStart() throws RemoteException {
		System.out.println("Lancement de la partie :" + name);
		usersPlay = usersInGame;

		// Selection aleatoire du premier joueur (index du tableau UserInGame)
		int random = (int) (Math.random() * (getUsersInGame().size()) + 1);
		currentUser = usersInGame.get(random - 1);
		indexCurrentUser = usersInGame.indexOf(currentUser);
		newPattern();
		// RMI
		System.out.println(usersInGame.toString());
		for (String userInGame : usersInGame) {
			System.out.println("gameIsStart : envoie a :" + UserManager.getItem(userInGame).getIP());
			ServerRMIClient.invokeRMIClient(UserManager.getItem(userInGame).getIP(), Actions.startGame,(currentUser + "," + getCurrentPattern()));
		}
		// Compte a rebour de la partie, lancé après pour prendre en compte la latence réseau
		timer = new TimerEg(10,name);
	}

	public void nextPlayer(String word) throws RemoteException {
		String ip;

		if (testWord(word)) {
			// si mot existe et non deja utilise => changement de joueur
			if (usersPlay.indexOf(this.currentUser) >= this.usersPlay.size() - 1) {
				indexCurrentUser = 0;
				currentUser = usersPlay.get(indexCurrentUser);
			} else {
				//currentUser = usersPlay.get(usersPlay.indexOf(usersPlay.indexOf(currentUser) + 1));
				indexCurrentUser++;
				currentUser = usersPlay.get(indexCurrentUser);
			}
			UserManager.getItem(this.currentUser).addChar(word);
			newPattern();
			
			// RMI
			for (String userInGame : usersInGame) {
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("nextPlayer : envoie a :" + ip);
				ServerRMIClient.invokeRMIClient(ip, Actions.nextPlayer, (currentUser + "," + getCurrentPattern()));
			}
		} else {
			String message;
			ip = UserManager.getItem(currentUser).getIP();
			if (isUsedWord(word)) {
				message = "Mot deja utilise";
			} else {
				message = "Mot non pr�sent dans le dictionnaire";
			}
			// RMI
			System.out.println("wordNotExist : envoie a :" + ip);
			ServerRMIClient.invokeRMIClient(ip, Actions.wordNotExist, message);
		}
		// System.out.println(getUsedWords());
		// System.out.println(UserManager.getItem(currentUser).getUsedChars());
	}

	// Methodes : Dico
	public boolean testWord(String word) {
		return dico.wordExiste(word);
	}

	public boolean isUsedWord(String word) {
		return dico.isUsedWord(word);
	}

	public String getCurrentPattern() {
		return dico.getCurrentPattern();
	}

	public String newPattern() {
		return dico.genPattern();
	}

	public ArrayList<String> getUsedWords() {
		return dico.getUsedWords();
	}

	@Override
	public String toString() {
		return "Game [usersInGame=" + usersInGame + ", usersPlay=" + usersPlay + ", usersLoose=" + usersLoose
				+ ", currentUser=" + currentUser + ", creator=" + creator + ", dico=" + dico + ", name=" + name + "]";
	}
}
