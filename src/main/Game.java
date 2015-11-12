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
	private Thread timer;
	private int state;
	private static final long serialVersionUID = 7605941372064698361L;

	// Contructeur
	public Game(String gamename, String dicoName, String creator) {
		super();
		this.name = gamename;
		this.creator = creator;
		this.state = 0;
		this.dico = new Dictionnary("dico1", "/media/benoit.menard/DATA/genie_logiciel/git/dictionnaire");
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

	public boolean addUserToGame(String username) {
		try {
			// Variables locales
			String ip;
			
			// Actions
			if (UserManager.getItem(username).getGame().equals("")){
				System.out.println(username+" a rejoint "+name);
				usersInGame.add(username);
				UserManager.getItem(username).setGame(name);
			}
			else {
				System.out.println("ERREUR : addUserToGame "+username+" est deja dans une partie");
				return false;
			}
			
			// RMI
			for (String userInGame : getUsersInGame()) {
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("addUserToGame : envoie a :" + UserManager.getItem(userInGame).getIP());
				ServerRMIClient.invokeRMIClient(ip, Actions.userJoinGame, username);
			}
			return usersInGame.contains(username);
		}
		catch (Exception e){
			System.out.println("ERREUR :"+username+" a rejoint "+name);
			e.printStackTrace();
			return usersInGame.contains(username);
		}
	}

	public boolean delUserToGame(String username){
		try {
			// Variables locales
			String ip;
			
			// Actions
			UserManager.getItem(username).setGame("");
			
			if (usersInGame.size() == 1){
				// Supression de la partie
				System.out.println("Plus de joueur dans la partie :"+name+" - supression");
				GameManager.delItem(name);
				return true;
			}
			else {
				usersInGame.remove(username);
			}
			
			// Changement de nom
			if (creator.equals(username)){
				System.out.println("L'hote de la partie quitte la session - Changement d'hote");
				creator=usersInGame.get(0);
				// RMI
				for (String userInGame : usersInGame) {
					ip = UserManager.getItem(userInGame).getIP();
					System.out.println("hoteExit : envoie a :" + UserManager.getItem(userInGame).getIP());
					ServerRMIClient.invokeRMIClient(ip, Actions.hoteQuit, creator);
				}
			}
			else {
				// RMI
				for (String userInGame : usersInGame) {
					ip = UserManager.getItem(userInGame).getIP();
					System.out.println("delUserToGame : envoie a :" + UserManager.getItem(userInGame).getIP());
					ServerRMIClient.invokeRMIClient(ip, Actions.userQuitGame, username);
				}
			}	
			System.out.println(username+" a quitt� "+name);
			return (!(usersInGame.contains(username)));
		}
		catch (Exception e) {
			System.out.println("ERREUR :"+username+" a quitt� "+name);
			e.printStackTrace();
			return (!(usersInGame.contains(username)));
		}
	}

	// Methodes : partie
	public boolean gameIsStart(){
		try {
			String ip;
			System.out.println("Server LOG : Lancement de la partie " + name);
			
			// Actions Copie du tableau usersInGame dans usersPlay
			usersPlay = usersInGame;
	
			// Selection aleatoire du premier joueur (index du tableau UserInGame)
			int random = (int) (Math.random() * (getUsersInGame().size()) + 1);
			currentUser = usersInGame.get(random - 1);
			indexCurrentUser = usersInGame.indexOf(currentUser);
			// Generation du premier pattern
			newPattern(); 
			// RMI - Voir pour mise en place des Threads
			for (String userInGame : usersInGame) {
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("gameIsStart : envoie a :" + UserManager.getItem(userInGame).getIP());
				ServerRMIClient.invokeRMIClient(ip, Actions.startGame,(currentUser + "," + getCurrentPattern()));
			}
			// Compte a rebour de la partie, lancé après pour prendre en compte la latence réseau
			timer = new Thread(new Timer(name));
			timer.start();
			state=1;
			return true;
		}
		catch (Exception e){
			System.out.println("ERREUR : gameIsStart de la partie "+name);
			e.printStackTrace();
			return false;
		}
	}

	public boolean nextPlayer(String word) {
		try {	
			String ip;
	
			if (testWord(word)) {
				// si mot existe et non deja utilise => changement de joueur
				if (usersPlay.indexOf(this.currentUser) >= this.usersPlay.size() - 1) {
					indexCurrentUser = 0;
					currentUser = usersPlay.get(indexCurrentUser);
				} else {
					indexCurrentUser++;
					currentUser = usersPlay.get(indexCurrentUser);
				}
				UserManager.getItem(this.currentUser).addChar(word);
				
				// Géneration du nouveaux pattern
				newPattern();
				
				// RMI
				for (String userInGame : usersInGame) {
					ip = UserManager.getItem(userInGame).getIP();
					System.out.println("nextPlayer : envoie a :" + ip);
					ServerRMIClient.invokeRMIClient(ip, Actions.nextPlayer, (currentUser + "," + getCurrentPattern()));
				}
				
				return true;
			} else {
				String message;
				ip = UserManager.getItem(currentUser).getIP();
				
				if (isUsedWord(word)) {
					message = "Mot deja utilise :"+word;
				} else {
					message = "Mot non present dans le dictionnaire :"+word;
				}
				
				// RMI
				for (String userInGame : usersInGame) {
					ip = UserManager.getItem(userInGame).getIP();
					System.out.println("wordNotExist : envoie a :" + ip);
					ServerRMIClient.invokeRMIClient(ip, Actions.wordNotExist, message);
				}
				//System.out.println("wordNotExist : envoie a :" + ip);
				//ServerRMIClient.invokeRMIClient(ip, Actions.wordNotExist, message);
				
				return false;
			}
		}	
		catch (Exception e){
			System.out.println("ERREUR : nextPlayer de la partie "+name);
			e.printStackTrace();
			return false;
		}
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

	public void timeElapsed() {
		try {
		String ip;
			for (String userInGame : usersInGame) {
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("timeElapsed : envoie a :" + UserManager.getItem(userInGame).getIP());
				ServerRMIClient.invokeRMIClient(ip, Actions.timeElapsed,currentUser);
			}
			state=0;
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
