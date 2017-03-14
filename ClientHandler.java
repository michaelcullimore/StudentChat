package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    static PrintWriter output;
    static BufferedReader input = null;
    static String fromUser;
    String studentName;
    InetAddress address;

    public ClientHandler(String name, InetAddress ip) {
	studentName = name;
	address = ip;
    }

    @Override
    public void run() {
	BufferedReader in = null;

	Socket myClient = null;

	try {
	    myClient = new Socket(address, 8090);
	    output = new PrintWriter(myClient.getOutputStream(), true);
	    in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));

	    input = new BufferedReader(new InputStreamReader(System.in));

	    String userInput;
	    while ((userInput = input.readLine()) != null) {
		output.println(userInput);
		System.out.println("echo: " + in.readLine());
	    }
	} catch (Exception e) {
	    try {
		ServerSocket ss = new ServerSocket(8090);

		ServerHandler sh = new ServerHandler(ss, studentName);
		new Thread(sh).start();

	    } catch (Exception e2) {
		e2.printStackTrace();
	    }

	    finally {
		String fromServer;
		Socket Client2 = null;
		PrintWriter out2 = null;
		try {
		    myClient = new Socket("localhost", 8090);
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		try {
		    output = new PrintWriter(myClient.getOutputStream(), true);
		} catch (IOException e1) {
		    e1.printStackTrace();
		}

		try {
		    in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
		} catch (IOException e1) {
		    e1.printStackTrace();
		}

		try {
		    while ((fromServer = in.readLine()) != null) {
			System.out.println("Server: " + fromServer);
			Client.textArea.append(fromServer + "\n");
			fromServer = "";

		    }
		} catch (IOException e1) {
		    e1.printStackTrace();
		}

	    }

	}

    }

    public Runnable start() {
	// TODO Auto-generated method stub
	return null;
    }
}
