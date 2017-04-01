//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

public class Group {
    public static void main(String[] args) {
	String[] testConvo1 = { "Hey!", "What are you up to?", "I'm just working on homework, so I can't do anything.",
		"I've done that for the past 4 nights.", "Well, you win. Bye." };
	String[] testConvo2 = { "Yo!", "Not much, you?", "Yeah, me too. I pulled an all nighter.",
		"I'm going on a week.", "Well, Bye." };
	Student student1 = new Student("Michael", "Cullimore", testConvo1);
	Student student2 = new Student("Sniglet", "Drapp", testConvo2);

	// tests the group setup Makes sure that students can be put in a group
	Group groupTest = new Group(student1, student2);
	System.out.println(groupTest.toString());// works!
    }

    Student sA;
    Student sB;

    public Group(Student student1, Student student2) {
	int compareFirstName = student1.getFirstName().compareTo(student2.getFirstName());
	if (student1.equals(student2)) {
	    throw new IllegalArgumentException("Error. Names must be unique.");
	}
	if (compareFirstName < 0) {
	    this.sA = student1;
	    this.sB = student2;
	} else if (compareFirstName > 0) {
	    this.sA = student2;
	    this.sB = student1;
	} else if (compareFirstName == 0) {
	    int compareLastName = student1.getLastName().compareTo(student2.getLastName());
	    if (student1.equals(student2)) {
		throw new IllegalArgumentException("Error. Names must be unique");
	    }
	    if (compareLastName < 0) {
		this.sA = student1;
		this.sB = student2;
	    } else if (compareLastName > 0) {
		this.sA = student2;
		this.sB = student1;
	    }
	}
    }

    @Override
    public String toString() {
	return "Group [sA = " + sA + ", sB = " + sB + "]";
    }

}