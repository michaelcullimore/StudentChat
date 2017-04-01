package cs3230;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chat {

    public static void main(String[] args) throws IOException {
	BufferedReader bReader = new BufferedReader(new FileReader("src/cs3230/studentList.csv"));
	String line;
	ArrayList<String> studentList = new ArrayList<>();

	String[] testConvo1 = { "Hey!", "What are you up to?", "I'm just working on homework, so I can't do anything.",
		"I've done that for the past 4 nights.", "Well, you win. Bye." };
	String[] testConvo2 = { "Yo!", "Not much, you?", "Yeah, me too. I pulled an all nighter.",
		"I'm going on a week.", "Well, Bye." };

	while ((line = bReader.readLine()) != null) {
	    String[] name = line.split(", ");
	    // Won't work. I'll try removing score since I still don't know what
	    // it's for.
	    studentList.add(new Student(name[0], name[1], testConvo2[2]));
	}

    }

}
