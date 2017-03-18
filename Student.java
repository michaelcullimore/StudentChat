//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.HashSet;

public class Student {
    String firstName;
    String lastName;

    // track the messages
    HashSet<String> thingsStudentHasSaid;

    public Student(String first, String last, int score1) {
	firstName = first;
	lastName = last;
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
