//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Group {
    // Represents class of students
    private ArrayList<Student> SortedClass;
    private Class classroom = new Class();

    // the conversations LIST

    private ArrayList<String> convo;

    // Read as Group to Students
    private HashMap<String, HashSet> GroupToStudents;
    private HashMap<Student, String> StudentToGroup;
    private HashMap<String, ArrayList> GroupToMessages;

    // Group size
    private int size;

    public Group() {
	SortedClass = new ArrayList<>();
	GroupToStudents = new HashMap<>();
	StudentToGroup = new HashMap<>();
	GroupToMessages = new HashMap<>();
	convo = new ArrayList<>();

	size = 0;

    }// end Group

    // Add 2 students to the chat group
    public void addStudentToGroup(Student Student1, Student Student2) {
	HashSet<Student> Groupof2Students = new HashSet<>();

	Groupof2Students.add(Student1);
	Groupof2Students.add(Student2);
	size++;

	GroupToStudents.put("Group" + size, Groupof2Students);
	StudentToGroup.put(Student1, "Group" + size);
	StudentToGroup.put(Student2, "Group" + size);

    }// end addStudentToGroup

    // chat method between 2 people
    public void Chat(Student s, String message) {
	String group = findStudentGroup(s.firstName);

	if (s.thingsStudentHasSaid.contains(s.firstName + " " + s.lastName + " : " + message)) {
	    return;
	} else {
	    convo.add(s.firstName + " " + s.lastName + " : " + message);
	    GroupToMessages.put(group, convo);
	    s.thingsStudentHasSaid.add(s.firstName + " " + s.lastName + " : " + message);
	} // end if/else

    }// end Chat

    // creates the student class
    public List<Student> CreateStudents() {
	Collections.sort(classroom.studentArrayList);
	for (String s : classroom.studentArrayList) {
	    String[] parts = s.split(" ");

	    Student asdf = new Student(parts[0], parts[1], 0);

	    SortedClass.add(asdf);

	} // end for

	return SortedClass;

    }// find CreateStudents

    // displays the convo
    public ArrayList<String> FindConversationsOfStudent(String firstName) {
	String group = findStudentGroup(firstName);

	ArrayList<String> conversation = GroupToMessages.get(group);

	return conversation;

    }// end FindConversationOfStudent

    // "Finds" a student based on the first name
    public Student findStudent(String first) {

	for (Student item : SortedClass) {
	    if (item.firstName.equals(first)) {
		return item;
	    } // end if

	} // end for

	return null;

    }// end findStudent

    private String findStudentGroup(String name) {
	Student s = findStudent(name);
	String group = StudentToGroup.get(s);
	return group;
    }// end findStudentGroup

    // generates the groups for the people in the class
    public int GenerateGroups(List<Student> allStudents) {
	int count = 0;
	for (int i = 0; i < allStudents.size() / 2; i++) {
	    addStudentToGroup(allStudents.get(count), allStudents.get(count + 1));
	    count = count + 2;
	} // end for

	return 0;

    }// end GenerateGroups

}