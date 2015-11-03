package chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class Receive implements Runnable {

	private BufferedReader in;
	private String message = null;
	
	public Receive(BufferedReader in){
		this.in = in;
	}
	public void run() {
		while(true){
	        try {
				message = in.readLine();
				System.out.println(message);
				for (Socket client : Server.getItems()){
					new Send(client,message);
				}
			}
		    catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

