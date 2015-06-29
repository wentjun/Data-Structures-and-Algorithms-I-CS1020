// This program reads two sets of integers A and B, and determines
// if A is a subset of B, and if A is same as B.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

class TestSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listSetA = new ArrayList<Integer>();
		ArrayList<Integer> listSetB = new ArrayList<Integer>();

		System.out.print("Enter number of elements in set A: ");
		int setASize = sc.nextInt();

		System.out.print("Enter elements for set A: ");
		for (int i = 0; i < setASize; i++) {
			listSetA.add(sc.nextInt());
		}

		System.out.print("Enter number of elements in set B: ");
		int setBSize = sc.nextInt();
		
	    System.out.print("Enter elements for set B: ");
		for (int i = 0; i < setBSize; i++) {
			listSetB.add(sc.nextInt());
		}
		
		Set setA = new Set(listSetA);
		Set setB = new Set(listSetB);
		
		System.out.println("Set A: " + listSetA);
		System.out.println("Set B: " + listSetB);
			
		if (setA.isSubset(setB) && setB.isSubset(setA)) {
			System.out.println("Set A is a subset of set B.");
			System.out.println("Set A is equal to set B.");
		} else if (setA.isSubset(setB)) {
			System.out.println("Set A is a subset of set B.");
			System.out.println("Set A is not equal to set B.");
		} else if (setB.isSubset(setA)) {
			System.out.println("Set A is not a subset of set B.");
			System.out.println("Set A is not equal to set B.");
		} else {
			System.out.println("Set A is not a subset of set B.");
			System.out.println("Set A is not equal to set B.");
		}
		
	}
} 
