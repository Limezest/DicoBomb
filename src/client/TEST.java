package client;

import java.rmi.RemoteException;
import java.util.Scanner;

class TEST implements Runnable {

	volatile boolean keepRunning = true;

	public void run() {
		System.out.println("Starting to loop.");
		while (keepRunning) {
			System.out.println("Running loop...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Done looping.");
	}

	public static void main(String[] args) throws RemoteException {
		ClientRMIClient cli = new ClientRMIClient("127.0.0.1");
		//System.out.println(cli.getGames());
		cli.sendMessage("", "benoit", "PART DE LA");
		// TEST test = new TEST();
		// Thread t = new Thread(test);
		// t.start();
		//
		// Scanner s = new Scanner(System.in);
		// while (!s.next().equals("stop"));
		//
		// test.keepRunning = false;
		// t.interrupt(); // cancel current sleep.
	}
}