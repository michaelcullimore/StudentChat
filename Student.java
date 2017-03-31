//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    public static void main(String[] args) {
	// make a test conversation, create a student
	String[] testconvo = { "test", "hi", "Guten Morgen!", "Hey", "g2g" };
	Student student01 = new Student("Michael", "Cullimore", 97.5, testconvo);

	// test
	System.out.println(student01.toString());// oh, I had a toString method
						 // earlier... Don't know what
						 // happened to it...
	System.out.println(student01.conversations.get(0));// gets elements from
							   // testconvo
	System.out.println(student01.conversations.get(1));// ""
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
	// TODO Auto-generated method stub
	return firstName;
    }

    public String getLastName() {
	// TODO Auto-generated method stub
	return lastName;
    }

    public double getScore() {
	// TODO Auto-generated method stub
	return score;
    }

    public void setScore(double score) {
	// TODO Auto-generated method stub
	this.score = score;
    }

    // generated toString
    @Override
    public String toString() {
	return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", conversations="
		+ conversations + "]";
    }

}
