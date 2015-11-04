package chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientServeur implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	public Thread t3;

	public ChatClientServeur(Socket s) {
		socket = s;
	}

	public void run() {

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			t3 = new Thread(new Receive(in));
			t3.start();
		} catch (IOException e) {
			System.err.println("s'est déconnecté ");
		}
	}
}
