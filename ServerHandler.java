//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private Socket socket;
    private BufferedReader inputStream;
    private String username;

    public ServerHandler(Socket s, String user) throws IOException {
	socket = s;
	inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	username = user;
    }

    @Override
    public void run() {
	String string01;
	try {
	    while ((string01 = inputStream.readLine()) != null) {
		Server.sendMessage(username + ": " + string01);
		System.out.println(username + ": " + string01);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
