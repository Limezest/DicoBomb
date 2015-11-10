package client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class cmdLineClient implements Runnable {
	private Thread keyboard;
	private Bomb bomb;
	@Override
	public void run() {
		try {
				Scanner sc = new Scanner(System.in);
				Client.crmic.nextPlayer(Client.mygame,  sc.nextLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
