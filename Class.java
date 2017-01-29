//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

package cs3230;

import java.util.ArrayList;

public class Class {
    ArrayList<String> studentArrayList;

    public Class() {
	studentArrayList = new ArrayList<>();
	classOfStudents();
    }

    // add students to the class
    private void classOfStudents() {
	// TODO Auto-generated method stub
	studentArrayList.add("Nathan Borup");
	studentArrayList.add("Ethan Brown");
	studentArrayList.add("Michael Cullimore");
	studentArrayList.add("Kendra Koester");
	studentArrayList.add("Trevor Marsh");
	studentArrayList.add("Cody May");
	studentArrayList.add("Brieanna Miller");
	studentArrayList.add("Rizwan Mohammed");
	studentArrayList.add("Lauren Ribeiro");
	studentArrayList.add("Tyler Toponce");
    }// end classOfStudents

}// end class Class
