import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.lang.System;
import java.lang.Thread;
import java.net.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class server extends Thread {
    private ServerSocket serverSocket;

    public server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            try {

                System.out.println("Waiting for client on port "
                                    + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("Connected to "
                                    + server.getOutputStream());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("oui");
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out");
                break;
            } catch (IOException e) {
                System.out.println(e.printStackTrace();
            }
        }
    }

}