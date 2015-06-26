// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex1
// Name: Chan Wen Tjun
// Matric. No.:	A0121262X	
// Lab group: 7
// This program creates a KWIC object, reads in a title list, and
// ignored word list. FOr each title, circular shift will happen to the first 
// word and the first word of each string cannot be from ignored word list.
// The program rreturns the valid permutations of the titles. All keywords
// will start with an upper-case letter.


import java.util.*;
import java.util.ArrayList;

class KWIC {
	private static ArrayList<String> ignoreWordList;
	private static ArrayList<String> titleList;
	private static ArrayList<String> finalResult;

	public KWIC() {
		ignoreWordList = new ArrayList<String>();
		titleList = new ArrayList<String>();
		finalResult = new ArrayList<String>();
	}

	/* Pre-condition:  input must be a String containing the title of the movie/
	/* Post-condition:  appends a String with the title to the end of the list
	/* Description: Add a new title to titleList. */
	public void addWordToTitleList(String word) {
		titleList.add(word);
	}

	/* Pre-condition: input must be a String containing the words to be ignored
	/* Post-condition: appends a String with ignored words to the end of the list
	/* Description: Add a new title to ignoreWordList. */
	public void addWordToIgnoreWordList(String word) {
		ignoreWordList.add(word);
	}

	/* Description: This method is to find the final result. */
	public static void findKWICIndex() {
		finalResult = orderInAlphabetical(circularShift(capitalizeKeyword()));
	}

	/* Pre-condition: finalResult ArrayList must be predetermined
	/* Post-condition:  prints out the different titles on separate lines, and sorted alphabetically
	/* Description: To print out the final result. */
	public static void printOutResult() {
		for (int i = 0; i <finalResult.size(); i++) {
			System.out.println(finalResult.get(i));
		}
	}

	/* Pre-condition: input must be list of titles with capitalized first letter of keywords
	/* Post-condition:  returns an ArrayList of the possible permutations
	/* Description: Receive a list of titles and wordToIgnore, circular shift all the titles and store them. */
	/* Note that wordToIgore cannot be in the beginning of a title. */
	private static ArrayList<String> circularShift(ArrayList<String> list) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < titleList.size(); i++) {

			String temp = list.get(i);
			int index = 0;
			while (!temp.equals(list.get(i)) || index == 0) {
				temp = temp.concat(" " + 
						temp.substring(0, temp.indexOf(" "))).substring(temp.indexOf(" ") + 1);
				if (Character.isUpperCase(temp.charAt(0))) {
					result.add(temp);
					index++;
				}
			}
		}
		return result;
	}

	/* Pre-condition:  input must be ArrayList of possible permutations of titles
	/* Post-condition:  returns an ArrayList of the list of title permutations in alphabetical order
	/* Description: To sort a list in alphabetical order. */
	private static ArrayList<String> orderInAlphabetical(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i; j < list.size(); j++) {
				if (list.get(i).compareToIgnoreCase(list.get(j)) > 0) {
					String temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		return list;
	}

	/* Pre-condition:  titleList with titles with whitespaces
	/* Post-condition:  returns the titleList with first letter of keywords capitalized
	/* Description: To capitalize every first character of keywords. */
	private static ArrayList<String> capitalizeKeyword() {

		for (int i = 0; i < titleList.size(); i++) {
			String word = "", title = "";
			for (int j = 0; j < titleList.get(i).length(); j++) {
				word = word + titleList.get(i).charAt(j);
				if (Character.isWhitespace(titleList.get(i).charAt(j)) ||
						j == titleList.get(i).length() - 1) {
					if (!ignoreWordList.contains(word.replace(" ", ""))) word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
					title = title + word;
					word = "";
				}
			}
			titleList.set(i, title.trim());
		}
		return titleList;
	}
}
