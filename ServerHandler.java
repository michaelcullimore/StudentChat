package cs3230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler implements Runnable {
    private ServerSocket ss;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private String studentName;

    public ServerHandler(ServerSocket s, String name) throws IOException {
	ss = s;
	studentName = name;
    }

    private PrintWriter PrintWriter(OutputStream outputStream, boolean b) {
	return null;
    }

    @Override
    public void run() {
	try {
	    socket = ss.accept();
	} catch (IOException e2) {
	    e2.printStackTrace();
	}
	try {
	    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    writer = PrintWriter(socket.getOutputStream(), true);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	String outputLine, inputLine;

	Group Groups = new Group();
	List<Student> temp = Groups.CreateStudents();
	Groups.GenerateGroups(temp);

	Student m = Groups.findStudent("Michael");
	Student n = Groups.findStudent("Nathan");
	Groups.Chat(m, "Hi");
	Groups.Chat(n, "Hello!!!");
	Groups.Chat(m, "Yo!");
	Groups.Chat(n, "Hey! :D");
	Groups.Chat(m, "I'm glad this works!");
	Groups.Chat(n, "What's goin' on?!");
	ArrayList<String> conversations = Groups.FindConversationsOfStudent(studentName);
	Student current = Groups.findStudent(studentName);
	int i = 0;
	int size = conversations.size();

	outputLine = conversations.get(i);

	try {
	    while (outputLine != null) {
		writer.println(outputLine);
		writer.flush();

		if (i == size - 1) {
		    break;
		} else {
		    i++;
		    outputLine = conversations.get(i);
		}
	    }
	    try {
		while ((inputLine = reader.readLine()) != null) {
		    Groups.Chat(current, inputLine);
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} finally {
	    try {
		reader.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    try {
		reader.close();
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }
	    try {
		socket.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	System.out.println(Thread.currentThread() + "new thread");
    }
}
