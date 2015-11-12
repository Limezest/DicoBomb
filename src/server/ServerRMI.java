package server;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import main.Game;
import main.GameManager;
import main.User;
import main.UserManager;

public class ServerRMI extends UnicastRemoteObject implements ServerRMInterface {
	private static final long serialVersionUID = 1L;

	protected ServerRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean newUser(String username) throws RemoteException {
		try {
			if (UserManager.addItem(username,getClientHost())){
				ServerRMIClient.addClient(getClientHost());
				return true;
			}
			else {return false;}
		}catch(Exception e){
			return false;
		}
	}

	public boolean newGame(String gamename, String dico,String creator) throws RemoteException {
		return GameManager.addItem(gamename, dico,creator);
	}

	public boolean quitGame(String username, String gamename) throws RemoteException {
		return GameManager.quitGame(username, gamename);
	}

	public ArrayList<Game> getGames() throws RemoteException {
		return GameManager.getItems();
	}

	public ArrayList<User> getUsers() throws RemoteException {
		return UserManager.getItems();
	}

	public boolean joinGame(String username, String gamename) throws RemoteException {
		return GameManager.joinGame(username, gamename);
	}

	public boolean userExit(String username) throws RemoteException {
		try {
			ServerRMIClient.delclient(getClientHost());
			return UserManager.delItem(username);
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean nextPlayer(String gamename,String word) throws RemoteException {
		return GameManager.nextPlayer(gamename,word);
	}

	public boolean startGame(String gamename) throws RemoteException {
		return GameManager.startGame(gamename);
	}


	public String newRandomUser() throws RemoteException {
		try {
			String randomUser = UserManager.randomName();
			if (UserManager.addItem(randomUser,getClientHost())){
				ServerRMIClient.addClient(getClientHost());
				return randomUser;
			}
			else {return "false";}
		}catch(Exception e){
			e.printStackTrace();
			return "false";
		}
	}


	public ArrayList<String> getUsersInGame(String gamename) throws RemoteException {
		return GameManager.getItem(gamename).getUsersInGame();
	}
	
	public void sendMessage(String gamename,String sender, String message) throws RemoteException {
		String ip;
		if (gamename.equals("")){
			//envoyer message à tout le monde
			for (User user : UserManager.getItems()){
				ip = user.getIP();
				System.out.println("sendMessage : envoie a :" + ip);
				ServerRMIClient.invokeRMIClient(ip, Actions.sendMessage, sender+","+message);
			}
		}
		else {
			for (String userInGame : GameManager.getItem(gamename).getUsersInGame()){
				ip = UserManager.getItem(userInGame).getIP();
				System.out.println("sendMessage : envoie a :" + ip);
				ServerRMIClient.invokeRMIClient(ip, Actions.sendMessage, sender+","+message);
			}
		}
	}
}