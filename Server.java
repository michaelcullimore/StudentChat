//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    public static ArrayList<PrintWriter> output;
    public static ArrayList<String> userList;

    public static void main(String[] args) throws IOException {
	new Thread(new Server()).start();
    }

    public static void sendMessage(String m) {
	for (PrintWriter p : output) {
	    p.println(m);
	    p.flush();
	}

    }

    private final int port = 8080;

    private PrintWriter newPW;

    public Server() throws IOException {
	userList = new ArrayList<>();
	output = new ArrayList<>();
    }

    @Override
    public void run() {
	try {
	    ServerSocket ss = new ServerSocket(port);
	    System.out.println("Waiting on conection to port: " + InetAddress.getLocalHost() + port);
	    try {
		while (true) {
		    Socket clientSocket = ss.accept();
		    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		    newPW = new PrintWriter(clientSocket.getOutputStream(), true);
		    System.out.println("Client Connected");
		    String username;
		    while (true) {
			username = br.readLine();
			if (userList.contains(username)) {
			    newPW.println("Username not found. Please Try Again.");
			} else {
			    newPW.println("Username Accepted. Thank You.");
			    userList.add(username);
			    break;
			}
		    }
		    ServerHandler sh = new ServerHandler(clientSocket, username);
		    System.out.println("Client Connected");
		    output.add(newPW);
		    new Thread(sh).start();
		}
	    } finally {
		ss.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
