//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Chat {

    public static void main(String[] args) throws IOException {
	Set<Student> students = new HashSet<>();

	String[] testConvo1c = { "Hello, does this thing work?", "Hey, how's it going?", "I'm fantastic", "Good",
		"Big Gulps, huh? Well, see ya later!" };
	String[] testConvo2c = { "Yo!", "Hey, how are you", "I'm good", "Good", "See ya" };

	BufferedReader bReader = new BufferedReader(new FileReader("src/cs3230/studentList.csv"));
	String line;

	while ((line = bReader.readLine()) != null) {
	    String[] name = line.split(",");// there cannot be any spaces here
	    students.add(new Student(name[0], name[1], testConvo1c));
	}

	bReader.close();

	ArrayList<Student> studentList = new ArrayList<>(students);
	studentList.sort(null);
	System.out.println(studentList);

	ArrayList<Group> groups = new ArrayList<>();

	for (int i = 0; i < students.size(); i++) {
	    // Don't need to increment here, just add 1. Incrementing gives an
	    // IndexOutOfBoundException
	    studentList.get(i + 1).setConvos(testConvo2c);
	    groups.add(new Group(studentList.get(i), studentList.get(++i)));
	}

	groups.sort(null);

	String ipAddress = JOptionPane.showInputDialog("Please enter IP Address of Server:");

	final int portNo = 8080;
	String string01 = "initilized";
	Socket socket01 = new Socket();
	Graphical window;
	BufferedReader br;

	try {
	    socket01.connect(new InetSocketAddress(ipAddress, portNo), 8080);
	} catch (Exception e) {
	    System.out.println("Connection has failed. Starting new server at " + InetAddress.getLocalHost());
	    new Thread(new Server()).start();
	    socket01.close();
	    socket01 = new Socket(InetAddress.getLocalHost(), portNo);
	}

	br = new BufferedReader(new InputStreamReader(socket01.getInputStream()));

	window = new Graphical(socket01);

	System.out.println(InetAddress.getLocalHost());

	// outputs the convos for each of the students
	for (int i = 0; i < groups.size(); i++) {
	    window.addText(groups.get(i).studentConversations());
	}

	window.addText("Enter Username: ");

	while (true) {
	    string01 = br.readLine();
	    if (string01.equals("ACK")) {
		window.addText("Username Accepted");
		break;
	    } else {
		window.addText("Username not found. Please try again.");
	    }

	}

	// controls server
	while ((string01 = br.readLine()) != null) {
	    window.addText(string01);
	}

    }

}
