// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex2
// Name: Chan Wen Tjun
// Matric. No.: A0121262X
// Lab group: 6
// This program calculates the minimum number of hops required to go from the 
// first block to the last block. The program first reads an input which represents the
// total number of blocks in the obstacle course. It then reads another set of inputs which represent
// the height of the block and the hopping range of the block.It returns the minimum number of hops required.

import java.util.Scanner;

public class ObstacleCourse {

	/**
	Description: Calculates minimum number of hops needed to hop to the last block
	Pre-condition(s): input block must be valid 
	*/
	public static int countHops(Block[] blocks, int currIndex) {
		// if there are no more blocks available to jump to
		if(currIndex == blocks.length - 1){
			return 0;
		} 

		int nextBlock = currIndex + 1; //for next reachable block     

		//Calculates the next reachable block by using the hopping range of the current block
		for(int i = nextBlock + 1; i<blocks.length; i++){
			if(blocks[i].getHeight() <= blocks[currIndex].getHoppingRange()){
				nextBlock = i;
			}
			else {
				break;
			}
		}

		return 1 + countHops(blocks, nextBlock);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Block[] blocks = new Block[n];
		for (int i = 0; i < n; i++) {
			blocks[i] = new Block(sc.nextInt(), sc.nextInt());
		}
		System.out.println(countHops(blocks, 0));
	}
}

class Block {

	private int height;
	private int hoppingRange;

	public Block(int height, int hoppingRange) {
		this.height = height;
		this.hoppingRange = hoppingRange;
	}

	public int getHeight() {
		return this.height;
	}

	public int getHoppingRange() {
		return this.hoppingRange;
	}

}

