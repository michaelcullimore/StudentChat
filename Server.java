//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {
    public static void main(String[] args) throws IOException {
	new Thread(new Server()).start();
    }

    private ArrayList<String> userList;
    private int port = 8080;

    public Server() throws IOException {

    }

    @Override
    public void run() {
	try {
	    ServerSocket ss = new ServerSocket(port);
	    System.out.println("Waiting on conection to port: " + port);
	    try {
		while (true) {
		    Socket s = ss.accept();
		    ServerHandler sh = new ServerHandler(s);
		    System.out.println("Conected");
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
