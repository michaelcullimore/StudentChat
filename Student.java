//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.HashSet;

public class Student {
    String firstName;// TODO
    String lastName;// TODO
    private int score;

    // track the messages
    HashSet<String> thingsStudentHasSaid;

    public Student(String first, String last, int score1) {
	setFirstName(first);
	setLastName(last);
	score = score1;
	thingsStudentHasSaid = new HashSet<>();

    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}
