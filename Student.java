//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student> {
    public static int idPlus = 1;

    public static void main(String[] args) {
	// make a test conversation, create a student
	String[] testConvo1s = { "test", "hi", "Guten Morgen!", "Good Morning!", "Let's go feed the ducks!",
		"How can you not like ducks?" };
	String[] testConvo2s = { "hey", "hello", "What does that mean?", "Oh, cool.", "I don't like ducks." };
	Student student01 = new Student("Michael", "Cullimore", testConvo1s);
	Student student02 = new Student("Kendra", "Koester", testConvo2s);

	// test
	System.out.println(student01.toString());// posts information about the
						 // student
	System.out.println(student02.toString());
	System.out.println(student01.conversations.get(0));// gets elements from
							   // testConvo
	System.out.println(student01.conversations.get(1));// ""
	System.out.println(student01.conversations.get(4));
	System.out.println(student02.conversations.get(3));
	System.out.println(student02.conversations.get(2));
	System.out.println(student01.conversations.get(5));
    }

    private String firstName;
    private String lastName;

    private double score;
    private final int studentIDNo;

    ArrayList<String> conversations;

    // create a student
    public Student(String firstN, String lastN, String[] testConvo2) {
	this.firstName = firstN;
	this.lastName = lastN;
	// this.score = _score;
	this.conversations = new ArrayList<>(Arrays.asList(testConvo2));
	studentIDNo = idPlus++;
    }

    @Override
    public int compareTo(Student o) {
	// TODO Auto-generated method stub
	String compareString = o.getFirstName() + o.getLastName();
	String stringStudent = this.getFirstName() + " " + this.getLastName();
	return stringStudent.compareToIgnoreCase(compareString);
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
	if (studentIDNo != other.studentIDNo) {
	    return false;
	}
	if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score)) {
	    return false;
	}
	return true;
    }

    public ArrayList<String> getConvos() {
	return conversations;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setConvos(ArrayList<String> conversations) {
	this.conversations = conversations;
    }

    public void setConvos(String[] conversations) {
	this.conversations = new ArrayList<>(Arrays.asList(conversations));
    }

    // shows information about the student
    @Override
    public String toString() {
	return "Student [firstName = " + firstName + "; lastName = " + lastName + "; studentIDNo = " + studentIDNo
		+ "; conversations = " + conversations + "]";
    }
}
