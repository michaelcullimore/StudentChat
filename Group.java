//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

public class Group implements Comparable<Group> {
    public static void main(String[] args) {
	String[] testConvo1g = { "Hello, does this thing work?", "Hey, how's it going?", "I'm fantastic", "Good",
		"Big Gulps, huh? Well, see ya later!" };
	String[] testConvo2g = { "Yo!", "Hey, how are you", "I'm good", "Good", "See ya" };
	Student student1 = new Student("Michael", "Cullimore", testConvo1g);
	Student student2 = new Student("Sniglet", "Drapp", testConvo2g);

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
    public int compareTo(Group o) {
	// TODO Auto-generated method stub
	String compareString = o.getStudentName();
	return this.getStudentName().compareToIgnoreCase(compareString);
    }

    public String getStudentName() {
	return this.sA.getFirstName() + " " + this.sB.getLastName();

    }

    public String studentConversations() {
	String name1 = sA.getFirstName() + " " + sA.getLastName();
	String name2 = sB.getFirstName() + " " + sB.getLastName();
	String chat = " ";

	int chatLength = Math.min(sA.conversations.size(), sB.conversations.size());
	for (int i = 0; i < chatLength; i++) {
	    chat += name1 + ": " + sA.conversations.get(i) + "\n";
	    chat += name2 + ": " + sA.conversations.get(i) + "\n";
	}
	return chat;
    }

    @Override
    public String toString() {
	return "Group [sA = " + sA + "; sB = " + sB + "]";
    }

}