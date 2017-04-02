//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private Socket socket;
    private BufferedReader inputStream;
    private PrintWriter outputStream;

    public ServerHandler(Socket s) throws IOException {
	socket = s;
	inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	outputStream = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
	outputStream.println("ACK");
	String str;
	try {
	    while ((str = inputStream.readLine()) != null) {
		outputStream.println(str);
		System.out.println("Client " + str);
		outputStream.flush();
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
