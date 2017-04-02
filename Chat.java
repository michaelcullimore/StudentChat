//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Chat {

    public static void main(String[] args) throws IOException {
	Set<Student> students = new HashSet<>();

	String[] testConvo1c = { "Hello, does this thing work?", "Hey, how's it going?", "I'm fantastic", "Good",
		"Big Gulps, huh? Well, see ya later!" };
	String[] testConvo2c = { "Yo!", "Hey, how are you", "I'm good", "Good", "See ya" };

	BufferedReader bReader = new BufferedReader(new FileReader("src/cs3230/studentList.csv"));
	String line;

	while ((line = bReader.readLine()) != null) {
	    String[] name = line.split(",");
	    students.add(new Student(name[0], name[1], testConvo2c));
	}
	bReader.close();

	System.out.println(students);

	ArrayList<Student> studentList = new ArrayList<>(students);
	studentList.sort(null);
	System.out.println(studentList);

	ArrayList<Group> groups = new ArrayList<>();
	for (int i = 0; i < students.size(); i++) {
	    // Don't need to increment here, just add 1. Incrementing gives an
	    // IndexOutOfBoundException
	    studentList.get(i + 1).setConvos(testConvo1c);
	    groups.add(new Group(studentList.get(i), studentList.get(++i)));
	}

	Graphical window = new Graphical();
	for (int i = 0; i < groups.size(); i++) {
	    window.addText(groups.get(i).studentConversations());
	}

    }

}
