package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultipleServerHandler implements Runnable {
    private static ArrayList<String> connectedUsers = new ArrayList<>();
    private static HashMap<Integer, Socket> list = new HashMap<>();
    private static int x = 0;
    private PrintWriter output;
    private BufferedReader input;
    protected Socket socket;
    private boolean set;
    private String studentName;

    public MultipleServerHandler(Socket incSocket) {
	socket = incSocket;
	set = false;
    }

    @Override
    public void run() {
	try {
	    // client input
	    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    // server output
	    output = new PrintWriter(socket.getOutputStream(), true);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	Group Groups = new Group();
	List<Student> temp = Groups.CreateStudents();
	Groups.GenerateGroups(temp);
	Student m = Groups.findStudent("Michael");
	Student n = Groups.findStudent("Nathan");
	Student current = null;
	Groups.Chat(m, "Hi");
	Groups.Chat(n, "Hello!!!");
	Groups.Chat(m, "Yo!");
	Groups.Chat(n, "Hey! :D");
	Groups.Chat(m, "I'm glad this works!");
	Groups.Chat(n, "What's goin' on?!");

	String outputLine = null;
	String inputLine = null;

	// input from user to server
	try {

	    while ((inputLine = input.readLine()) != null) {

		if (set == false) {
		    studentName = inputLine;

		    if (!connectedUsers.contains(studentName)) {
			list.put(x, socket);
			x++;
			connectedUsers.add(studentName);
			outputLine = "ACK\n";

			if (Groups.findStudent(studentName) != null) {
			    ArrayList<String> conversations = Groups.FindConversationsOfStudent(studentName);
			    current = Groups.findStudent(studentName);
			    int size = conversations.size();

			    for (int i = 0; i < size; i++) {
				outputLine = conversations.get(i);
				output.println(outputLine);
				output.flush();
				outputLine = "";
			    }

			    set = true;
			    continue;
			}
		    }

		    else {
			outputLine = "Denied\n";
			output.println(outputLine);
			socket.close();
			return;
		    }
		}

		// sends message to all students. student must be part of the
		// class
		for (int i = 0; i < list.size(); i++) {
		    Socket sockets = list.get(i);
		    PrintWriter output2 = new PrintWriter(sockets.getOutputStream(), true);
		    output2.println(current.firstName + " " + current.lastName + ": " + inputLine);
		}

		output.flush();

	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
