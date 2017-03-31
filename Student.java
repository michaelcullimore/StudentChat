//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    public static void main(String[] args) {
	// make a test conversation, create a student
	String[] testconvo = { "test", "hi", "Guten Morgen!", "How are you?", "Let's go feed the ducks!" };
	Student student01 = new Student("Michael", "Cullimore", 97.5, testconvo);

	// test
	System.out.println(student01.toString());// posts information about the
						 // student
	System.out.println(student01.conversations.get(0));// gets elements from
							   // testconvo
	System.out.println(student01.conversations.get(1));// ""
	System.out.println(student01.conversations.get(4));
    }

    private String firstName;
    private String lastName;
    private double score;

    ArrayList<String> conversations;

    // create a student
    public Student(String firstN, String lastN, double _score, String[] convos) {
	this.firstName = firstN;
	this.lastName = lastN;
	this.score = _score;
	this.conversations = new ArrayList<>(Arrays.asList(convos));
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public double getScore() {
	return score;
    }

    public void setScore(double score) {
	this.score = score;
    }

    // shows information about the student
    @Override
    public String toString() {
	return "Student [firstName = " + firstName + ", lastName = " + lastName + ", score = " + score
		+ ", conversations = " + conversations + "]";
    }

}
