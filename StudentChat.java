//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.List;

public class StudentChat {

    // test all the objects
    public static void main(String[] args) {
	Group Groups = new Group();
	List<Student> temp = Groups.CreateStudents();
	Groups.GenerateGroups(temp);

	Student s = Groups.findStudent("Michael");
	Student r = Groups.findStudent("Kendra");

	Groups.Chat(s, "Hi");
	Groups.Chat(s, "Yo!");
	Groups.Chat(r, "Hello!!!");
	Groups.Chat(r, "Hey! :D");
	Groups.Chat(r, "What's goin' on?!");

	ArrayList<String> a = Groups.FindConversationsofStudent("Michael");

	for (String item : a) {
	    System.out.println(item);
	}

    }

}