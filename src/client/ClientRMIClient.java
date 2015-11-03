package client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientRMIClient {
	private ClientMessageHandler clientManager;
	private String pseudo;
	private ArrayList<User> users;
	private ArrayList<Game> games;
	public ClientCmndLine()
	{
		clientManager = new ClientMessageHandler();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("entrer votre pseudo :");
		this.pseudo=(keyboard.nextLine());
		keyboard.close();
		System.out.println("Hi, "+this.pseudo+"!  ");
		try {
			clientManager.newUser(this.pseudo);
			this.users = clientManager.getUsers();
			this.games = clientManager.getGames();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
    
    public static void main (String [] argv) {
			ClientCmndLine cl = new ClientCmndLine(); 
			
    }
}
