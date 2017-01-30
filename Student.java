//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.HashSet;

public class Student {
    // Student values
    public String firstName;
    public String lastName;
    private int score;

    // Super easy way to keep track of repeated messages
    public HashSet<String> thingsStudentHasSaid;

    public Student(String first, String last, int score1) {
	firstName = first;
	lastName = last;
	score = score1;
	thingsStudentHasSaid = new HashSet<>();

    }// end Student

}// end class
