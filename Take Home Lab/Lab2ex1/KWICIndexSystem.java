// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex1
// Name: Chan Wen Tjun
// Matric. No.: A0121262X
// Lab group: 7
// This program reads the input and returns the possible permutations of titles


import java.util.*;

public class KWICIndexSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KWIC inputTitle = new KWIC();
		int numberOfIgnoredWords = sc.nextInt();
		
		sc.nextLine();
		
		for (int i = 0; i < numberOfIgnoredWords; i++) {
			inputTitle.addWordToIgnoreWordList(sc.nextLine());
		}
		
		int numberOfTitles = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < numberOfTitles; i++) {
			inputTitle.addWordToTitleList(sc.nextLine());
		}
		
		sc.close();
		
		KWIC.findKWICIndex();
		KWIC.printOutResult();
	}
}
