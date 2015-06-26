// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex3
// Name: CHAN WEN TJUN 
// Matric. No.: A0121262
// Lab group: 7
// The MyMap class consists of 2 two-dimensional arrays,
// the character grid representing the map, and an integer array
// that stores the number of neighbouring mines in each mine-free location.

import java.util.*;

class MyMap {
	private char[][] charMap; // Map containing the characters (labels)
	private int[][] intMap;  // Map containing the gold values
	private int nRow; // number of rows
	private int nCol; // number of columns

	public MyMap() {};  

	public MyMap(Scanner sc) {       
		nRow = sc.nextInt();
		nCol = sc.nextInt();
		charMap = new char[nRow][nCol];
		intMap = new int[nRow][nCol];   
		String line;
		for (int i = 0; i < nRow; i++) {
			line = sc.next();
			for (int j = 0; j < nCol; j++) {        
				setLabel(i, j, line.charAt(j));
				setGoldVal(i, j, 0);        
			}
		}
	}

	public int getNumRow() { 
		return nRow; 
	}

	public int getNumCol() { 
		return nCol; 
	}

	public char getLabel(int row, int col) { 
		return charMap[row][col]; 
	}

	public int getGoldVal(int row, int col) { 
		return intMap[row][col]; 
	}

	public void setLabel(int row, int col, char label) { 
		charMap[row][col] = label; 
	}

	public void setGoldVal(int row, int col, int val) { 
		intMap[row][col] = val; 
	}

	// Return true if row, col are within valid range,
	// otherwise return false.
	public boolean indexWithinRange(int row, int col) {
		// fill in the code
		int max_row = this.intMap.length;
		int max_col = this.intMap[0].length;
		return row < max_row && col < max_col;
	}

	// To print the character map
	public void display() {
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				if (j == nCol - 1) {
					if (getGoldVal(i, j) == -1) {
						System.out.println("*");
					} else {
						System.out.println(getGoldVal(i, j));
					}
				} else {
					if (getGoldVal(i, j) == -1) {
						System.out.print("*");
					} else {
						System.out.print(getGoldVal(i, j));
					}
				}
			}
		}
	}

}
