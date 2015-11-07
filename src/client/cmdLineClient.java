package client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class cmdLineClient implements Runnable {
	public String inputKeyboard(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	@Override
	public void run() {
		try {
			client.Client.crmic.nextPlayer("Partie1", inputKeyboard());
			return;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
