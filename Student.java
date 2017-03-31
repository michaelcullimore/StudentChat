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

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null) {
	    return false;
	}
	Student other = (Student) o;
	if (conversations == null) {
	    if (other.conversations != null) {
		return false;
	    }
	} else if (!conversations.equals(other.conversations)) {
	    return false;
	}
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName)) {
	    return false;
	}
	if (lastName == null) {
	    if (other.lastName != null) {
		return false;
	    }
	} else if (!lastName.equals(other.lastName)) {
	    return false;
	}
	if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score)) {
	    return false;
	}
	return true;
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

    public int hashcode() {
	int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	long x;
	x = Double.doubleToLongBits(score);
	result = prime * result + (int) (x ^ (x >>> 32));
	return result;
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
