// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex3
// Name: CHAN WEN TJUN 
// Matric. No.: A0121262X
// Lab group: 7
// This program generates a map based on the number of columns and rows, with the gold values.
// It takes into account the position of mines, and the amount of gold in the surrounding cells
// will increase proportionally with amount of adjacent mines.

import java.util.*;

public class GoldHunter {
	
	private String buildGoldMapString(MyMap map) {
		String result = "";
		for (int row = 0; row < map.getNumRow(); row++) {
			for (int col = 0; col < map.getNumCol(); col++) {
				if (this.isBomb(row, col, map)) {
					result += "*";
				} else {
					int gold_value = map.getGoldVal(row, col);
					result += gold_value;
				}
			}
			result += "\n";
			}
			return result;
	}

	//checks for bomb at the current row and column
	private boolean isBomb(int row, int col, MyMap map) {
		return map.getLabel(row, col) == '*';
	}

	// generates the map with gold values
	private MyMap generateGoldMap(MyMap map) {
		int max_col = map.getNumCol();
		int max_row = map.getNumRow();

		for (int row = 0; row < max_row; row++) {
			for (int col = 0; col < max_col; col++) {
				if (this.isBomb(row, col, map)) {
					map = this.increaseNeighbourGoldValue(row, col, map);
				}
			}
		}
		return map;
	}

	//checks for gold value, and increases if gold is present
	private MyMap increaseNeighbourGoldValue(int row, int col, MyMap map) {
		int top = Math.max(0, row - 1);
		int bottom = Math.min(row + 1, map.getNumRow() - 1);
		int left = Math.max(0, col - 1);
		int right = Math.min(col + 1, map.getNumCol() - 1);
		
		for (int i = top; i <= bottom; i++) {
			for (int j = left; j<= right; j++) {
				if (i != row || j != col) {
					if (!this.isBomb(i, j, map)) {
						int goldValue = map.getGoldVal(i, j);
						goldValue += 1;
						map.setGoldVal(i, j, goldValue);
					}
				}
			}
		}
		return map;
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MyMap map = new MyMap(sc);

		// To check before anything is done.
		// Remove the statement below after you have tested your program.
		GoldHunter oneGoldHunter = new GoldHunter();

		map = oneGoldHunter.generateGoldMap(map);
		
		String goldMap = oneGoldHunter.buildGoldMapString(map);
		System.out.print(goldMap);
	}
}

