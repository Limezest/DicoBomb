package chatServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Send {

	private PrintWriter out;
	
	public Send(Socket socket,String message) throws IOException {
		this.out = new PrintWriter(socket.getOutputStream());
		out.println(message);
	    out.flush();
	}
}

