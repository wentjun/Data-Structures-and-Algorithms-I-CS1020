// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex1
// Name: Chan Wen Tjun
// Matric. No.: A0121262X
// Lab group: 7
// This program reads an input which represents the total size of the luggage.
// Subsequently, it will read as many input as the user desires, whereby the input
// represents the size of the item and its value. When the user terminates the program,
// the program will compute the maximum value that the luggage can fit based on the inputs,
// and return the total size and value that fills the luggage.

import java.util.*;

class Item{
	private int value;
	private int size;

	public Item() {
		this(0, 0);
	}

	public Item(int size,int value) {
		this.value=value;
		this.size=size;
	}

	public int getValue() {
		return value;
	}

	public int getSize() {
		return size;
	}
	
	//adds 2 items together
	public void addItem(Item i) {
		value = value + i.getValue();
		size = size + i.getSize();
	}

	public String toString() {
		return "" + size + " " + value;
	}
}

public class Packing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Item> items = new ArrayList<Item>();

		//read in the data
		int size = sc.nextInt();
		int itemValue = 0;
		int itemSize = 0;
		String input = new String();
		sc.nextLine();

		while (sc.hasNext()) {
			input = sc.nextLine();
			String[] part = input.split(" ");
			itemSize = Integer.parseInt(part[0]);
			itemValue = Integer.parseInt(part[1]);
			items.add(new Item(itemSize, itemValue));
		}
		

		ArrayList<Item> allCombinations = select(items, size);
		Item bestPack = new Item();
		
		// selects combination with highest value and fits within the luggage size
		for (int i = 0; i < allCombinations.size(); i++) {
			if (allCombinations.get(i).getValue() > bestPack.getValue()) {
				bestPack = allCombinations.get(i);
			}

			if (allCombinations.get(i).getValue() == bestPack.getValue()) {
				if (allCombinations.get(i).getSize() < bestPack.getSize()) {
					bestPack = allCombinations.get(i);
				}
			}
		}

		System.out.println(bestPack);

		//implement the selection procedures recursively
		sc.close();
	}
	
	//description: overloading method
	//precondition: ArrayList must be of valid input
	public static ArrayList<Item> select(ArrayList<Item> remaining, 
			int remainingSpace) {
		ArrayList<Item> selected = new ArrayList<Item>();
		ArrayList<Item> result = new ArrayList<Item>();

		return select(remaining, selected, remainingSpace, result);
	}

	//description: finds the different combinations of filling up the luggage and adds to the result.
	//precondition: ArrayList must be of valid input 
	//You can change the signature of this method if you want, but you have to use recursion. 
	public static ArrayList<Item> select(ArrayList<Item> remaining, 
			ArrayList<Item> selected, int remainingSpace, ArrayList<Item> result) {

		Item removed = new Item();

		if (remaining.isEmpty()) {
			Item sum = new Item();
			
			while(!selected.isEmpty()) {
				sum.addItem(selected.remove(0));
			}
			result.add(sum);
		} else {
			for (int i = 0; i <remaining.size(); i++) {
				ArrayList<Item> copyRemaining = copy(remaining);
				ArrayList<Item> copySelected = copy(selected);

				if (copyRemaining.get(i).getSize() <= remainingSpace) {
					removed = copyRemaining.remove(i);
					copySelected.add(removed);
					select(copyRemaining, copySelected, remainingSpace - remaining.get(i).getSize(), result);
				} else {
					copyRemaining.remove(i);
					select(copyRemaining, copySelected, remainingSpace - remaining.get(i).getSize(), result);
				}
			}
		}
		return result;
	}

	//this method makes a copy of an existing Arraylist
	public static ArrayList<Item> copy(ArrayList<Item> arrlist) {
		return new ArrayList<Item>(arrlist);

	}

	//add other methods if you need

}

