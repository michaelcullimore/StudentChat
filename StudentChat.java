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

	Student m = Groups.findStudent("Michael");
	Student k = Groups.findStudent("Kendra");

	//
	Groups.Chat(m, "Hi");
	Groups.Chat(k, "Hello!!!");
	Groups.Chat(m, "Yo!");
	Groups.Chat(k, "Hey! :D");
	Groups.Chat(m, "I'm glad this works!");
	Groups.Chat(k, "What's goin' on?!");

	ArrayList<String> a = Groups.FindConversationsOfStudent("Michael");

	for (String item : a) {
	    System.out.println(item);
	} // end for

    }// end main

}// end class