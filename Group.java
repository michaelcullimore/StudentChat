//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

public class Group {
    public static void main(String[] args) {
	String[] testConvo = { "test", "hi", "Guten Morgen!", "How are you?", "Let's go feed the ducks!" };
	Student student1 = new Student("Michael", "Cullimore", 97.5, testConvo);
	Student student2 = new Student("Sniglet", "Drapp", -40.5, testConvo);

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