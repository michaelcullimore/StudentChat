//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.List;

public class StudentChat {

    public static void main(String[] args) {
	Group Groups = new Group();
	List<Student> temp = Groups.CreateStudents();
	Groups.GenerateGroups(temp);

	// sample of a group (more can be added)
	Student m = Groups.findStudent("Michael");
	Student n = Groups.findStudent("Nathan");

	// sample text (more can be written)
	Groups.Chat(m, "Hi");
	Groups.Chat(n, "Hello!!!");
	Groups.Chat(m, "Yo!");
	Groups.Chat(n, "Hey! :D");
	Groups.Chat(m, "I'm glad this works!");
	Groups.Chat(n, "What's goin' on?!");

	ArrayList<String> a = Groups.FindConversationsOfStudent("Michael");

	// prints the chat items
	for (String item : a) {
	    System.out.println(item);
	}

	// new Client("Student Chat v1.0");

    }

}